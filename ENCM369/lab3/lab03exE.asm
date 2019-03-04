# stub2.asm
# ENCM 369 Winter 2019 Lab 3
# This program has complete start-up and clean-up code, and a "stub"
# main function. It's exactly the same as stub1.asm from Lab 2, except
# that comments have been added to help explain the organization of main.

# BEGINNING of start-up & clean-up code.  Do NOT edit this code.
	.data
exit_msg_1:
	.asciiz	"***About to exit. main returned "
exit_msg_2:
	.asciiz	".***\n"
main_rv:
	.word	0
	
	.text
	# adjust $sp, then call main
	addi	$t0, $zero, -32		# $t0 = 0xffffffe0
	and	$sp, $sp, $t0		# round $sp down to multiple of 32
	jal	main
	nop
	
	# when main is done, print its return value, then halt the program
	sw	$v0, main_rv	
	la	$a0, exit_msg_1
	addi	$v0, $zero, 4
	syscall
	nop
	lw	$a0, main_rv
	addi	$v0, $zero, 1
	syscall
	nop
	la	$a0, exit_msg_2
	addi	$v0, $zero, 4
	syscall
	nop
	addi	$v0, $zero, 10
	syscall
	nop	
# END of start-up & clean-up code.

# Below is the stub for main. Edit it to give main the desired behaviour.
	.data
	.globl aaa
	aaa: .word 11, 11, 3, -11
	
	.data
	.globl bbb
	bbb: .word 200, -300, 400, 500
	
	.data
	.globl ccc
	ccc: .word -2, -3, 2, 1, 2, 3
	
	.text
	.globl	main
	
	# Variable	Register
	# red		$s0
	# green		$s1
	# blue		$s2
	
main:
	# If main needs a prologue, start it here.
	addi $sp, $sp, -32
	sw $a2, 28($sp)
	sw $a1, 24($sp)
	sw $a0, 20($sp)
	sw $s2, 16($sp)
	sw $s1, 12($sp)
	sw $s0, 8($sp)
	# Start body of main here.
	addi $s2, $zero, 1000		# blue = 1000
	la $a0, aaa			# $a0 = *aaa
	addi $a1, $zero, 4
	addi $a2, $zero, 10
	jal special_num
	add $s0, $zero, $v0		# red = special_num()
	
	la $a0, bbb			# $a0 = *bbb
	addi $a1, $zero, 4
	addi $a2, $zero, 200
	jal special_num
	add $s1, $zero, $v0		# green = special_num()
	
	la $a0, ccc			# $a0 = *ccc
	addi $a1, $zero, 6
	addi $a2, $zero, 500
	jal special_num
	add $t0, $zero, $v0		# $t0 = special_num()
	sub $t0, $t0, $s0		# $t0 = special_num() - red
	add $t0, $t0, $s1		# $t0 = special_num() - red + green
	add $s2, $s2, $t0		# blue += $t0
	
	add	$v0, $zero, $zero	# return value from main = 0
	
	# If main needs an epilogue, start it here.
	
	jr	$ra
	
special_num:

	# Variable		Register
	# x			$s0
	# n			$s1
	# b			$s2
	# result		$s3
	# i			$s4
	# $a0 (x)		$s5
	# $a1 (n)		$s6
	# $a2 (b)		$s7
	
	# prologue
	addi $sp, $sp, -32
	sw $ra, 28($sp)
	sw $s6, 24($sp)
	sw $s5, 20($sp)
	sw $s4, 16($sp)
	sw $s3, 12($sp)
	sw $s2, 8($sp)
	sw $s1, 4($sp)
	sw $s0, 0($sp)
	
	# body
	add $s0, $zero, $a0
	add $s1, $zero, $a1
	add $s2, $zero, $a2
	
	add $s3, $zero, $zero		# result = 0
	add $s4, $zero, $zero		# i = 0
L1:
	slt $t1, $s4, $s1		# $t1 = ( $s4 < $a1 ) // i < n == 1 TRUE
	beq $t1, $zero, endL1		# if (i >= n) goto endL1
	
	sll $t9, $s4, 2			# $t9 = i * 4
	add $t2, $s0, $t9		# $t2 = x + 4i
	lw $a0, ($t2)			# $a0 = x[i]
	add $a1, $zero, $s2		# $a1 = b 
	jal saturate
	add $s3, $s3, $v0		# result += saturate()
	
	addi $s4, $s4, 1		# i++
	j L1
endL1:
	add $v0, $zero, $s3
	
	# epilogue
	lw $ra, 28($sp)
	lw $s6, 24($sp)
	lw $s5, 20($sp)
	lw $s4, 16($sp)
	lw $s3, 12($sp)
	lw $s2, 8($sp)
	lw $s1, 4($sp)
	lw $s0, 0($sp)
	addi $sp, $sp, 32
	jr $ra
	
saturate:
	
	# Variable		Register
	# result		$t3
	
	# body
	add $t3, $zero, $a0
	
	slt $t4, $a1, $a0		# $t4 = ( bound < a )

	bne $t4, $zero, If1
	sub $t5, $zero, $a1		# $t5 = -bound
		
	slt $t6, $a0, $t5		# $t7 = (a < -bound)
	bne $t6, $zero, If2
	j end
If1:	
	add $t3, $zero, $a1		# result = bound
	j end
	
If2:
	add $t3, $zero, $t5		# result = -bound
	j end

 end:
 	add $v0, $zero, $t3
 	jr $ra 		
