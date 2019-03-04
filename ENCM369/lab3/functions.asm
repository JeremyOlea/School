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
	.globl car
car:	.word 0x30000
	
	.text
	.globl	main
main:
	# Variable           Register
	# truck			$s0
	# boat			$s1
	
	# If main needs a prologue, start it here.
	addi $sp, $sp, -32
	sw $a3, 28($sp)
	sw $a2, 24($sp)
	sw $a1, 20($sp)
	sw $a0, 16($sp)
	sw $ra, 12($sp)
	sw $s2, 8($sp)
	sw $s1, 4($sp)
	sw $s0, 0($sp)
	
	# Start body of main here.
	add $s0, $zero, $zero		# int truck
	add $s1, $zero, $zero		# int boat	
	addi $s0, $zero, 0x2000		# truck = 0x2000
	addi $s1, $zero, 0x7000		# boat = 0x7000
	
	addi $a0, $zero, 5		# $a0 = 5
	addi $a1, $zero, 4
	addi $a2, $zero, 3
	addi $a3, $zero, 2
	
	jal first
	add $s0, $s0, $v0		#truck = first()
	add $s1, $s1, 1			# boat++
	la $s2, car			# $s2 = car
	sll $t0, $s0, 2			# $t0 = truck * 4
	add $t0, $t0, $s1		# $t0 = boat + truck*4
	lw $t1, ($s2)			# $t1 = *car
	add $t1, $t1, $t0		# $t1 = car + (boat + truck*4)
	sw $t1, ($s2)			# car = car + boat + truck*4
	
	add	$v0, $zero, $zero	# return value from main = 0
	
	# If main needs an epilogue, start it here.
	jr	$ra
	
	.text
	.globl first
	
first:
	# Variable		Register
	# red			$s4
	# blue			$s5
	# green			$s6
	addi $sp, $sp, -32
	sw $ra, 28($sp)
	sw $s6, 24($sp)
	sw $s5, 20($sp)
	sw $s4, 16($sp)
	sw $s3, 12($sp)
	sw $s2, 8($sp)
	sw $s1, 4($sp)
	sw $s0, 0($sp)
	
	add $s4, $zero, $zero	# red = 0
	add $s5, $zero, $zero	# blue = 0
	add $s6, $zero, $zero	# green = 0
	add $s0, $zero, $a0	# $s0 = arg 0
	add $s1, $zero, $a1	# $s1 = arg1
	add $s2, $zero, $a2	# $s2 = arg 2
	add $s3, $zero, $a3	# $s3 = arg 3
	
	add $a0, $zero, $s3 
	add $a1, $zero, $s1
	jal second
	add $s5, $zero, $v0	# blue = second()
	
	add $a0, $zero, $s2
	add $a1, $zero, $s0
	jal second
	add $s6, $zero, $v0	# green = second()
	
	add $a0, $zero, $s1
	add $a1, $zero, $s2
	jal second
	add $s4, $zero, $v0	# red = second()
	
	add $t2, $s4, $s5	# red += blue
	add $t3, $t2, $s6	#(red+blue) += green asd
	add $v0, $zero, $t3	# $v0 = (red+blue+green)
	
	#epilogue
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
	
	.text
	.globl second
	
second:
	sll $v0, $a1, 8		# //dog *= 256 
	add $v0, $v0, $a0	# $v0 = cat + dog*256
	jr $ra
	
	
	
	
	