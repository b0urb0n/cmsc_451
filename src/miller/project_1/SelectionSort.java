package miller.project_1;

public class SelectionSort implements SortInterface {
  private int count = 0;
  private long time = 0;
  
  @Override
  public void recursiveSort(int[] list) throws UnsortedException {
    long startTime = System.currentTimeMillis();

    //TODO
    
    time = System.currentTimeMillis() - startTime;
  }

  @Override
  public void iterativeSort(int[] list) throws UnsortedException {
    long startTime = System.currentTimeMillis();

    //TODO
    
    time = System.currentTimeMillis() - startTime;
  } 

  @Override
  public int getCount() {
    return this.count;
  }

  @Override
  public long getTime() {
    return this.time;
  }
  
  public void resetTimeAndCount() {
    this.time = 0;
    this.count = 0;
  }
}
