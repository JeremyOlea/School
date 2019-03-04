// functions.c: ENCM 369 Winter 2019 Lab 3 Exercise C 

// INSTRUCTIONS:
//   You are to write a MARS translation of this C program.  Because
//   this is the first assembly language program you are writing where you
//   must deal with register conflicts and manage the stack, there are
//   a lot of hints given in C comments about how to do the translation.
//   In future lab exercises and on midterms, you will be expected
//   to do this kind of translation without being given very many hints!


// Hint: Function prototypes, such as the next two lines of C,
// are used by a C compiler to do type checking and sometimes type
// conversions in function calls.  They do NOT cause ANY assembly
// language code to be generated.

int first(int arg0, int arg1, int arg2, int arg3);

int second(int cat, int dog);

int car = 0x30000;

int main(void)
{
  // Hint: This is a nonleaf procedure, so it needs a stack frame.

  // Instruction: Normally you could pick whatever two s-registers you
  // like for truck and boat, but in this exercise you must use $s0
  // for truck and $s1 for boat.

  int truck;
  int boat;
  truck = 0x2000;
  boat = 0x7000;
  truck += first(5, 4, 3, 2);
  boat++;
  car += (boat + 4 * truck);

  // At this point car should have a value of 0x42025
 
  return 0;
}

int first(int arg0, int arg1, int arg2, int arg3)
{
  // Hint: This is a nonleaf procedure, so it needs a stack frame,
  // and you will have to make copies of the incoming arguments so
  // that a-registers are free for outgoing arguments.

  // Instructions: Normally you would have a lot of freedom within the
  // calling conventions about what s-registers you use, and about where
  // you put copies of incoming arguments, but in this exercise you
  // must copy arg0 to $s0, arg1 to $s1, arg2 to $s2, and arg2 to $s3, 
  // and use $s4 for red, $s5 for blue, and $s6 for green.

  int red, blue, green;
  blue = second(arg3, arg1);
  green = second(arg2, arg0);
  red = second(arg1, arg2);

  return red + blue + green;
}

int second(int cat, int dog)
{
  // Hint: this is a leaf procedure, and it shouldn't need to use any
  // s-registers, so you should not have use the stack at all.
  return cat + dog * 256;
}