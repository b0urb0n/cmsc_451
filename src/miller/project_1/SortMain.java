package miller.project_1;

public class SortMain {
  private static int[] sizes;
  private static BenchmarkSorts bs;
  
  public static void main(String[] args) {
    // warmup
    sizes = new int[] { 50, 1000, 10000 };
    bs = new BenchmarkSorts(sizes);
    
    try {
      bs.runSorts();
    } catch (UnsortedException e) {
    }
    // end warmup
    
    sizes = new int[] { 10, 50, 100, 200, 400, 800, 1000, 2000, 5000, 10000 };
    bs = new BenchmarkSorts(sizes);
    
    try {
      bs.runSorts();
    } catch (UnsortedException e) {
      System.out.print(e.getMessage());
    }
    
    bs.displayReport();
  }
}
