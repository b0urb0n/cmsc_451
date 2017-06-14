package miller.project_1;

public class SortMain {
  public static void main(String[] args) {
    int[] sizes = new int[] { 10, 50, 100, 200, 400, 800, 1000, 2000, 5000, 10000 };
    
    BenchmarkSorts bs = new BenchmarkSorts(sizes);
    
    try{
      bs.runSorts();
    } catch (UnsortedException e) {
      System.out.print(e.getMessage());
    }
    
    bs.displayReport();
  }
}
