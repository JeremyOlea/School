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
	.text
	.globl aaa
	aaa: .word 11, 11, 3, -11
	
	.text
	.globl bbb
	bbb: .word 200, -300, 400, 500
	
	.text
	.globl ccc
	ccc: .word -2, -3, 2, 1, 2, 3
	
	.text
	.globl	main
main:
	#Variable	Register
#	red		s0
#	green		s1
#	blue		s2
	# If main needs a prologue, start it here.
	addi $sp, $sp, -32
	sw $s0, 0($sp)
	sw $s1, 4($sp)
	sw $s2, 8($sp)
	sw $ra, 12($sp)
	sw $a0, 16($sp)
	sw $a1, 20($sp)
	sw $a2, 24($sp)
	# Start body of main here.
	addi $s2, $zero, 1000
	
	la $t0, aaa
	lw $a0, ($t0)
	addi $a1, $zero, 4
	addi $a2, $zero, 10
	jal special_num
	add $s0, $zero, $v0
	
	la $t1, bbb
	lw $a0, ($t1)
	addi $a1, $zero, 4
	addi $a2, $zero, 200
	jal special_sum
	add $s1, $zero, $v0
	
	la $t2, ccc
	lw $a0, ($t2)
	addi $a1, $zero, 6
	addi $a2, $zero, 500
	jal special_num
	sub $t3, $v0, $s0
	add $t3, $zero, $s1
	add $s2, $s2, $t3
	
	add	$v0, $zero, $zero	# return value from main = 0
	
	# If main needs an epilogue, start it here.
	jr	$ra
	
	.text
	.globl special_sum
special_sum:
# 	Variable	Register
#	a0		$s0
#	a1		s1
#	a2		s2
#	result		s3
#	i		s4

	#prologue
	addi $sp, $sp, -32
	sw, $s0, 0($sp)
	sw, $s1, 4($sp)	
	sw, $s2, 8($sp)	
	sw, $s3, 12($sp)	
	sw, $s4, 16($sp)	
	sw, $ra, 20($sp)	
	add $s0, $a0, $zero
	add $s1, $a1, $zero
	add $s2, $a2, $zero
	
	#body
	addi $s3, $zero, 0	
	addi $s4, $zero, 0
	L1:
	slt $t4, $s4, $s1	# t4 = i < n
	beq $t4, $zero, end
	sll $t5, $s4, 2		# t5 = i*4
	add $t6, $t5, $s0	# t6 = x+i
	lw $a0, ($t6)		# a0 = x[i]
	add $a1, $s2, $zero
	jal saturate
	add $s3, $s3, $v0
	addi $s4, $s4, 1
	j L1
	end:
	add $v0, $zero, $s3
	
	#epilogue
	lw, $s0, 0($sp)
	lw, $s1, 4($sp)	
	lw, $s2, 8($sp)	
	lw, $s3, 12($sp)	
	lw, $s4, 16($sp)	
	lw, $ra, 20($sp)
	addi $sp, $sp, 32
	jr $ra