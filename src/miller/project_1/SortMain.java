package miller.project_1;

public class SortMain {
  private static int[] sizes;
  private static BenchmarkSorts bs;
  
  public static void main(String[] args) {
    // warmup
    sizes = new int[] { 10000, 10000 }; // two 10000's should get the proper code paths "hot"
    bs = new BenchmarkSorts(sizes);
    
    try {
      bs.runSorts();
    } catch (UnsortedException e) {}
    // end warmup
    
    sizes = new int[] { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };
    bs = new BenchmarkSorts(sizes);
    
    try {
      bs.runSorts();
    } catch (UnsortedException e) {
      System.out.print(e.getMessage());
    }
    
    bs.displayReport();
  }
}
