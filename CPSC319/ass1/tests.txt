public static void main(String[] args) {    
    try {
      PrintWriter pw = new PrintWriter(new File("assignmentOneTestsNoRecursive.csv"));
      StringBuilder csvHeader = new StringBuilder();
      csvHeader.append(
          "Nth Fibonacci Number,Recursive Algorithm Runtime (ms),Recursive Algorithm Runtime (ns),Iterative Algorithm Runtime (ms),");
      csvHeader.append(
          "Iterative Algorithm Runtime (ns), Matrix-Based Algorithm Runtime (ms), Matrix-Based Algorithm Runtime (ns)\n");
      pw.write(csvHeader.toString());

      runExperimentalTests(0, pw);
      runExperimentalTests(1, pw);
      runExperimentalTests(2, pw);
      runExperimentalTests(4, pw);
      for (int i = 5; i <= 45; i += 5) {
        runExperimentalTests(i, pw);
      }
      // runExperimentalTests(75, pw);
      // runExperimentalTests(100, pw);
      pw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void runExperimentalTests(int n, PrintWriter pw) {
    pw.write(Integer.toString(n));
    pw.write(',');
    pw.write(runRecursiveTests(n));
    pw.write(runIterativeTests(n));
    pw.write(runMatrixTests(n));
    pw.write("\n");    
  }

  public static String runRecursiveTests(int n) {
    StringBuilder currentLine = new StringBuilder();    
    long startMS = System.currentTimeMillis();
    recursiveFibonacci(n);
    long endMS = System.currentTimeMillis();
    currentLine.append(Long.toString(endMS - startMS));
    currentLine.append(',');

    long startNS = System.nanoTime();
    recursiveFibonacci(n);
    long endNS = System.nanoTime();
    currentLine.append(Long.toString(endNS - startNS));
    currentLine.append(',');
    return currentLine.toString();
  }

  public static String runIterativeTests(int n) {
    StringBuilder currentLine = new StringBuilder();
    long startMS = System.currentTimeMillis();
    iterativeFibonacci(n);
    long endMS = System.currentTimeMillis();
    currentLine.append(Long.toString(endMS - startMS));
    currentLine.append(',');

    long startNS = System.nanoTime();
    iterativeFibonacci(n);
    long endNS = System.nanoTime();
    currentLine.append(Long.toString(endNS - startNS));
    currentLine.append(',');
    return currentLine.toString();
  }

  public static String runMatrixTests(int n) {
    StringBuilder currentLine = new StringBuilder();
    long startMS = System.currentTimeMillis();
    matrixFibonacci(n);
    long endMS = System.currentTimeMillis();
    currentLine.append(Long.toString(endMS - startMS));
    currentLine.append(',');

    long startNS = System.nanoTime();
    matrixFibonacci(n);
    long endNS = System.nanoTime();
    currentLine.append(Long.toString(endNS - startNS));
    return currentLine.toString();
  }