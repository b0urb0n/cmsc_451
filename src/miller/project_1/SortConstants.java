package miller.project_1;

public class SortConstants {
  public static final String TITLE = "Selection Sort Benchmark (Iterative and Recursive)";
  public static final String RESULT_D = "|%8d|%10.3f|%10.3f|%10.3f|%10.3f|%10.3f|%10.3f|%10.3f|%10.3f|\n";
  public static final String RESULT_S = "|%8s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n";
  public static final String RESULTS_HEADER = String.format("|%8s|%43s|%43s|", "Size n", "Iterative", "Recursive");
  public static final String RESULTS_SUB_HEADER = String.format(RESULT_S, "", "Avg Op #", "Std Dev", "Avg Time", "Std Dev", "Avg Op #", "Std Dev", "Avg Time", "Std Dev");
}
