package miller.project_1;

public class BenchmarkSorts {
  public static final int TEST_COUNT = 50;
  
  private SelectionSort sort;
  private SortMetrics metrics;
  private int[][][] lists;
  
  public BenchmarkSorts(int[] sizes) {
    sort = new SelectionSort();
    metrics = new SortMetrics(sizes.length);
    lists = new int[sizes.length][TEST_COUNT][];
    
    for(int i=0; i<lists.length; i++) {
      for(int j=0; j<lists[i].length; j++) {
        lists[i][j] = getRandomArray(sizes[i]);
      }
    }
  }
  
  public void runSorts() throws UnsortedException {
    for(int i=0; i<lists.length; i++) {
      for(int j=0; j<lists[i].length; j++) {
        int[] reArray, itArray;
        reArray = lists[i][j].clone();
        itArray = lists[i][j].clone();
        
        sort.recursiveSort(reArray);
        if(! isSorted(reArray)) {
          //throw new UnsortedException("Recursive method did not sort.\n");
        }
        metrics.recursiveCount[i][j] = sort.getCount();
        metrics.recursiveTime[i][j] = sort.getTime();
        sort.resetTimeAndCount();
        
        sort.iterativeSort(itArray);
        if(! isSorted(itArray)) {
          throw new UnsortedException("Iterative method did not sort.\n");
        }
        metrics.iterativeCount[i][j] = sort.getCount();
        metrics.iterativeTime[i][j] = sort.getTime();
        sort.resetTimeAndCount();
      }
    }
  }
  
  public void displayReport() {
    SortMetrics.SORT_TYPE iter = SortMetrics.SORT_TYPE.ITERATIVE;
    SortMetrics.SORT_TYPE rec = SortMetrics.SORT_TYPE.RECURSIVE;
    double ica, icsd, ita, itsd, rca, rcsd, rta, rtsd;
    
    System.out.println(SortConstants.TITLE);
    System.out.println(SortConstants.RESULTS_HEADER);
    System.out.print(SortConstants.RESULTS_SUB_HEADER);
    for (int i=0; i<lists.length; i++) {
      // "Avg Op Cnt", "Std Dev", "Avg Time", "Std Dev"
      ica = metrics.countAverage(iter, i);
      icsd = metrics.countSD(iter, i);
      ita = metrics.timeAverage(iter, i);
      itsd = metrics.timeSD(iter, i);
      
      rca = metrics.countAverage(rec, i);
      rcsd = metrics.countSD(rec, i);
      rta = metrics.timeAverage(rec, i);
      rtsd = metrics.timeSD(rec, i);
      
      System.out.format(SortConstants.RESULT_D, lists[i][0].length, ica, icsd, ita, itsd, rca, rcsd, rta, rtsd);
    }
    System.out.println();
  }
  
  public static boolean isSorted(int[] list) {
    for(int i=0; i<list.length-1; i++)
      if(list[i] > list[i+1])
        return false;
    return true;
  }

  private int[] getRandomArray(int size) {
    int[] arr = new int[size];
    
    for(int i=0; i<size; i++) {
      arr[i] = (int)(Math.random() * Integer.MAX_VALUE);
    }
    
    return arr;
  }
}
