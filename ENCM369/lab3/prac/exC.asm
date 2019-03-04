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
	.text
	.globl car
	car: .word 0x30000

# Below is the stub for main. Edit it to give main the desired behaviour.
	.text
	.globl	main
main:
	#Variable		Register
	#truck			$s0
	#boat			$s1
	#int*			$s2
	
	# If main needs a prologue, start it here.
	addi $sp, $sp, -32
	sw $s0, 32($sp)
	sw $s1, 28($sp)
	sw $s2, 24($sp)
	sw $a0, 20($sp)
	sw $a1, 16($sp)
	sw $a2, 12($sp)
	sw $a3, 8($sp)
	sw $ra, 4($sp)
	# Start body of main here.
	addi $s0, $zero, 0x2000		# truck = 0x2000
	addi $s1, $zero, 0x7000		# boat = 0x7000
	addi $a0, $zero, 5
	addi $a1, $zero, 4
	addi $a2, $zero, 3
	addi $a3, $zero, 2
	jal first
	add $s0, $s0, $v0		# truck += first()
	addi $s1, $s1, 1
	sll $t0, $s0, 2			# t0 = truck * 4
	addi $t0, $t0, $s1		# t0 = boat + truck * 4
	la $t1, car
	lw $t2, ($t1)			# t2 = *car
	add $t2, $t2, $t0		# t2 = car + boat + truck *4
	sw $t2, ($t1)			# *car = t2
	add	$v0, $zero, $zero	# return value from main = 0
	
	# If main needs an epilogue, start it here.
	jr	$ra
	
	.text
	.globl first
first:
	#Variable	Register
	#$a0		$s0
	#$a1		$s1
	#$a2		$s2
	#$a3		$s3
	#red		$s4
	#blue		$s5
	#green		$s6
	
	#prologue
	addi $sp, $sp, -32
	sw $s0, 32($sp)
	sw $s1, 28($sp)
	sw $s2, 24($sp)
	sw $s3, 20($sp)
	sw $s4, 16($sp)
	sw $s5, 12($sp)
	sw $s6, 8($sp)
	sw $s7, 4($sp)
	sw $ra, 0($sp)
	
	add $s0, $zero, $a0
	add $s1, $zero, $a1
	add $s2, $zero, $a2
	add $s3, $zero, $a3
	
	#body
	add $a0, $s3, $zero	# a0 = arg3
	add $a1, $s1, $zero	# a1 = arg1
	jal second
	add $s5, $zero, $v0
	
	add $a0, $s2, $zero
	add $a1, $s0, $zero
	jal second
	add $s6, $zero, $v0
	
	add $a0, $s1, $zero
	add $a1, $s2, $zero
	jal second
	add $s4, $zero, $v0
	
	add $t3, $s6, $s5
	add $t3, $t3, $s4
	add $v0, $zero, $t3
	
	#epilogue
	lw $s0, 32($sp)
	lw $s1, 28($sp)
	lw $s2, 24($sp)
	lw $s3, 20($sp)
	lw $s4, 16($sp)
	lw $s5, 12($sp)
	lw $s6, 8($sp)
	lw $s7, 4($sp)
	lw $ra, 0($sp
	addi $sp, $sp, 32
	jr $ra
	
	.text
	.globl second
second:
	sll $t3, $a1, 8
	add $v0, $a0, $t3
	jr $ra
	
	