package miller.project_1;

public class SortMetrics {
  public int[][] iterativeCount;
  public int[][] recursiveCount;

  public long[][] iterativeTime;
  public long[][] recursiveTime;

  public static enum SORT_TYPE { ITERATIVE, RECURSIVE };
  
  public SortMetrics(int size) {
    recursiveCount = new int[size][BenchmarkSorts.TEST_COUNT];
    iterativeCount = new int[size][BenchmarkSorts.TEST_COUNT];
    recursiveTime = new long[size][BenchmarkSorts.TEST_COUNT];
    iterativeTime = new long[size][BenchmarkSorts.TEST_COUNT];
  }
  
  public double countAverage(SORT_TYPE s, int index) {
    int[] arr;
    if (s == SORT_TYPE.ITERATIVE) {
      arr = iterativeCount[index];
    } else {
      arr = recursiveCount[index];
    }
    
    return average(arr);
  }
  
  public double timeAverage(SORT_TYPE s, int index) {
    long[] arr;
    if (s == SORT_TYPE.ITERATIVE) {
      arr = iterativeTime[index];
    } else {
      arr = recursiveTime[index];
    }
    
    return average(arr);
  }
  
  public double countSD(SORT_TYPE s, int index) {
    int[] arr;
    if (s == SORT_TYPE.ITERATIVE) {
      arr = iterativeCount[index];
    } else {
      arr = recursiveCount[index];
    }

    return standardDeviation(arr);
  }
  
  public double timeSD(SORT_TYPE s, int index) {
    long[] arr;
    if (s == SORT_TYPE.ITERATIVE) {
      arr = iterativeTime[index];
    } else {
      arr = recursiveTime[index];
    }

    return standardDeviation(arr);
  }
  
  private static double standardDeviation(int[] data) {
    double[] sd = new double[BenchmarkSorts.TEST_COUNT];
    double av = average(data);
    double diff;
    
    for(int i=0; i<data.length; i++) {
      diff = data[i] - av;
      sd[i] = diff * diff;
    }
    
    return Math.sqrt(average(sd));
  }

  private static double standardDeviation(long[] data) {
    double[] sd = new double[BenchmarkSorts.TEST_COUNT];
    double av = average(data);
    double diff;
    
    for(int i=0; i<data.length; i++) {
      diff = data[i] - av;
      sd[i] = diff * diff;
    }
    
    return Math.sqrt(average(sd));
  }
  
  private static double average(int[] data) {
    double ret = 0;
    for(int i=0; i<data.length; i++) {
      ret += data[i];
    }
    return ret/data.length;
  }
  
  private static double average(long[] data) {
    double ret = 0;
    for(int i=0; i<data.length; i++) {
      ret += data[i];
    }
    return ret/data.length;
  }
  
  private static double average(double[] data) {
    double ret = 0;
    for(int i=0; i<data.length; i++) {
      ret += data[i];
    }
    return ret/data.length;
  }  
}
