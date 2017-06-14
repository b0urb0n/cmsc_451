package miller.project_1;

public class BenchmarkSorts {
  private SelectionSort sort;
  
  private int[][][] list;
  private long[][] iterativeCounts;
  private long[][] iterativeTimes;
  private int[][] recursiveCounts;
  private long[][] recursiveTimes;
  
  private long[] iterativeCountAverages;
  private long[] iterativeTimeAverages;
  private int[] recursiveCountAverages;
  private long[] recursiveTimeAverages;
  
  public BenchmarkSorts(int[] sizes) {
    sort = new SelectionSort();
    list = new int[sizes.length][100][];
    
    for(int i=0; i<list.length; i++) {
      for(int j=0; j<list[i].length; j++) {
        list[i][j] = getRandomArray(sizes[i]);
      }
    }
    
    recursiveCountAverages = new int[list.length];
    recursiveTimeAverages = new long[list.length];
    iterativeCountAverages = new long[list.length];
    iterativeTimeAverages = new long[list.length];
    
    recursiveCounts = new int[list.length][list[0].length];
    recursiveTimes = new long[list.length][list[0].length];
    iterativeCounts = new long[list.length][list[0].length];
    iterativeTimes = new long[list.length][list[0].length];
  }
  
  public void runSorts() throws UnsortedException {
    for(int i=0; i<list.length; i++) {
      for(int j=0; j<list[i].length; j++) {
        int[] reArray, itArray;
        reArray = list[i][j].clone();
        itArray = list[i][j].clone();
        
        sort.recursiveSort(reArray);
        if(! isSorted(reArray)) {
          throw new UnsortedException("Recursive method did not sort.\n");
        }
        recursiveCounts[i][j] = sort.getCount();
        recursiveTimes[i][j] = sort.getTime();
        sort.resetTimeAndCount();
        
        sort.iterativeSort(itArray);
        if(! isSorted(itArray)) {
          throw new UnsortedException("Iterative method did not sort.\n");
        }
        iterativeCounts[i][j] = sort.getCount();
        iterativeTimes[i][j] = sort.getTime();
        sort.resetTimeAndCount();
      }
      
      recursiveCountAverages[i] = average(recursiveCounts[i]);
      recursiveTimeAverages[i] = average(recursiveTimes[i]);
      iterativeCountAverages[i] = average(iterativeCounts[i]);
      iterativeTimeAverages[i] = average(iterativeTimes[i]);
    }
  }
  
  private int average(int[] integers) {
    int a = 0;
    
    for(int i=0; i<integers.length; i++) {
      a += integers[i];
    }
    
    return a/integers.length;
  }
  
  private long average(long[] longs) {
    long a = 0;
    
    for(int i=0; i<longs.length; i++) {
      a += longs[i];
    }
    
    return a/longs.length;
  }
  
  private double average(double[] doubles) {
    double a = 0;
    
    for(int i=0; i<doubles.length; i++) {
      a += doubles[i];
    }
    
    return a/doubles.length;
  }
  
  public double sd(int[] data) {
    double[] s = new double[data.length];
    double av = average(data);
    double diff;
    
    for(int i=0; i<data.length; i++) {
      diff = data[i] - av;
      s[i] = diff * diff;
    }
    
    return Math.sqrt(average(s));
  }
  
  public double sd(long[] data) {
    double[] s = new double[data.length];
    double av = average(data);
    double diff;
    
    for(int i=0; i<data.length; i++) {
      diff = data[i] - av;
      s[i] = diff * diff;
    }
    
    return Math.sqrt(average(s));
  }
  
  public void displayReport() {
    //TODO: build table
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
