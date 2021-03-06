# string-funcs.asm
# ENCM 369 Winter 2019 Lab 4 Exercise C

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

#	void copycat(char *dest, const char *src1, const char *src2)
#
	.text
	.globl	copycat
copycat:
#	Variable	Register
#	c		$t0
#	*src1		$t1
#	*src2		$t2

	# Students: Replace this comment with appropriate code.
	L1:
	lbu $t1, ($a1)	# $t1 = *src1
	beq $t1, $zero, endL1 # if(*src == \0) goto endL1
	sb $t1, ($a0)	# *dest = *src1
	addi $a0, $a0, 1 # dest++
	addi $a1, $a1, 1 # src1++
	j L1
	endL1:
	
	L2:
	lbu $t2, ($a2) # $t2 = *src2
	lb $t0, ($a2) # c = *src
	sb $t0, ($a0) # *dest = c
	addi $a0, $a0, 1 # dest++
	addi $a2, $a2, 1 # src2++
	bne $t2, $zero, L2
	jr	$ra
	
#	void lab4reverse(const char *str)
#	
	.text
	.globl	lab4reverse
lab4reverse:

	# Students: Replace this comment with appropriate code.
#	Variables	Register
#	$t0		back
#	$t2		front
#	$t5		c

	add $t0, $zero, $zero	# back = 0
	L3:
	add $t1, $a0, $t0	# $t1 = str + back
	lbu $t4, ($t1)		# $t4 = *str[back]
	beq $t4, $zero, endL3	# if(str[back] == \0) goto endL3
	addi $t0, $t0, 1	# back++
	j L3
	endL3:
	
	addi $t0, $t0, -1	# back--
	add $t2, $zero, $zero	# front = 0
	
	L4:
	slt $t3, $t2, $t0	# t3 = front < back
	beq $t3, $zero, endL4	# if( front >= back) goto endL4
	add $t1, $a0, $t0	# $t1 = str + back
	lbu $t5, ($t1)		# c = str[back]
	add $t6, $a0, $t2	# $t6 = str + front
	lbu $t7, ($t6)		# $t7 = str[front]
	sb $t7, ($t1)		# str[back] = str[front]
	sb $t5, ($t6)		# str[front] = c
	addi $t0, $t0, -1
	addi $t2, $t2, 1
	j L4
	endL4:
	jr	$ra

	
#	void print_in_quotes(const char *str)
#
	.text
	.globl	print_in_quotes
print_in_quotes:
	add	$t0, $a0, $zero		# copy str to $t0	
	
	addi	$a0, $zero, '"'
	addi	$v0, $zero, 11
	syscall
	add	$a0, $zero, $t0
	addi	$v0, $zero, 4
	syscall
	addi	$a0, $zero, '"'
	addi	$v0, $zero, 11
	syscall
	addi	$a0, $zero, '\n'
	addi	$v0, $zero, 11
	syscall
	jr	$ra		
		
#	Global arrays of char for use in testing copycat and lab4reverse.
	.data
	
	.align	5
	# char array1[32] = { '\0', '*', ..., '*' };
array1:	.byte	0, '*', '*', '*', '*', '*', '*', '*'	
	.byte	'*', '*', '*', '*', '*', '*', '*', '*'	
	.byte	'*', '*', '*', '*', '*', '*', '*', '*'	
	.byte	'*', '*', '*', '*', '*', '*', '*', '*'
	
	# char array2[] = "X";	
array2:	.asciiz "X"
		
	# char array3[] = "YZ";	
array3:	.asciiz "YZ"
		
	# char array4[] = "123456";	
array4:	.asciiz "123456"
		
	# char array5[] = "789abcdef";	
array5:	.asciiz "789abcdef"
		
#	int main(void)
#
#	string constants used by main
	.data
sc0:	.asciiz ""
sc1:	.asciiz	"good"
sc2:	.asciiz "bye"
sc3:	.asciiz "After 1st call to copycat, array1 has "
sc4:	.asciiz "After 2nd call to copycat, array1 has "
sc5:	.asciiz "After 3rd call to copycat, array1 has "
sc6:	.asciiz "After 4th call to copycat, array1 has "
sc7:	.asciiz "After use of lab4reverse, array2 has "
sc8:	.asciiz "After use of lab4reverse, array3 has "
sc9:	.asciiz "After use of lab4reverse, array4 has "
sc10:	.asciiz "After use of lab4reverse, array5 has "

	.text
	.globl	main
main:
	# Prologue only needs to save $ra
	addi	$sp, $sp, -32
	sw	$ra, 0($sp)
	
	# Body
	# Start tests of copycat.
	la	$a0, array1		# $a0 = array1
	la	$a1, sc0		# $a1 = sc0
	la	$a2, sc0		# $a2 = sc0
	jal	copycat
	la	$a0, sc3
	addi	$v0, $zero, 4
	syscall	
	la	$a0, array1		# $a0 = array1
	jal	print_in_quotes
	
	la	$a0, array1		# $a0 = array1
	la	$a1, sc1		# $a1 = sc1
	la	$a2, sc0		# $a2 = sc0
	jal	copycat
	la	$a0, sc4
	addi	$v0, $zero, 4
	syscall	
	la	$a0, array1		# $a0 = array1
	jal	print_in_quotes
	
	la	$a0, array1		# $a0 = array1
	la	$a1, sc0		# $a1 = sc0
	la	$a2, sc2		# $a2 = sc2
	jal	copycat
	la	$a0, sc5
	addi	$v0, $zero, 4
	syscall	
	la	$a0, array1		# $a0 = array1
	jal	print_in_quotes
	
	la	$a0, array1		# $a0 = array1
	la	$a1, sc1		# $a1 = sc1
	la	$a2, sc2		# $a2 = sc2
	jal	copycat
	la	$a0, sc6
	addi	$v0, $zero, 4
	syscall	
	la	$a0, array1		# $a0 = array1
	jal	print_in_quotes
	
	# End tests of lab4cat; start tests of lab4reverse.
	la	$a0, array2		# $a0 = array2
	jal	lab4reverse
	la	$a0, sc7
	addi	$v0, $zero, 4
	syscall
	la	$a0, array2		# $a0 = array2
	jal	print_in_quotes
	
	la	$a0, array3		# $a0 = array3
	jal	lab4reverse
	la	$a0, sc8
	addi	$v0, $zero, 4
	syscall
	la	$a0, array3		# $a0 = array3
	jal	print_in_quotes
	
	la	$a0, array4		# $a0 = array4
	jal	lab4reverse
	la	$a0, sc9
	addi	$v0, $zero, 4
	syscall
	la	$a0, array4		# $a0 = array4
	jal	print_in_quotes
	
	la	$a0, array5		# $a0 = array5
	jal	lab4reverse
	la	$a0, sc10
	addi	$v0, $zero, 4
	syscall
	la	$a0, array5		# $a0 = array5
	jal	print_in_quotes
		
	# End tests of lab4reverse.
	
	add	$v0, $zero, $zero	# rv from main = 0
	
	# Epilogue
	lw	$ra, 0($sp)
	addi	$sp, $sp, 32
	jr	$ra