# swap.asm
# ENCM 369 Winter 2019 Lab 3 Exercise F

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

# int foo[] =  {0x11, 0x21, 0x31, 0x41, 0x51, 0x61}
	.data
        .globl	foo
foo:	.word	0x11, 0x21, 0x31, 0x41, 0x51, 0x61

# int main(void)
#
        .text
        .globl  main
main:
	addi	$sp, $sp, -32
 	sw 	$ra, 0($sp)

	la	$t0, foo	# $t0 = &foo[0]
	addi	$a0, $t0, 8	# $a0 = &foo[2]
	addi	$a1, $t0, 12	# $a1 = &foo[3]
	jal	swap

	# Students: Replace this comment with code to correctly
	# implement the next two calls to swap in main in swap.c.
	addi $a0, $t0, 20
	addi $a1, $t0, 0
	jal swap
	
	addi $a0, $t0, 4
	addi $a1, $t0, 16
	jal swap 

	add	$v0, $zero, $zero		
	lw	$ra, 0($sp)
	addi	$sp, $sp, 32
	jr	$ra

# void swap(int *a, int *b)
#
	.text
	.globl  swap
swap:
	# Students: Replace this comment with code to make swap
	# do its job correctly.
	
	# Variable		Register
	# original_star_a	$s0
	# original_star_b	$s1
	
	# body
	lw $s0, ($a0)		# original_star_a = *a
	lw $s1, ($a1)		# original_star_b = *b
	sw $s1, ($a0)		# *a = original_star_b
	sw $s0, ($a1)		# *b = original_star_a
	
	lw $s2, ($a0)		#41
	lw $s3, ($a1)		#32

	jr	$ra
