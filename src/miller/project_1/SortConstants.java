package miller.project_1;

public class SortConstants {
  public static final String TITLE = "Selection Sort Benchmark (Iterative and Recursive)";
  public static final String RESULT_D = "|%8d|%11.1f|%10.1f|%13.3f|%12.3f|%11.1f|%10.1f|%13.3f|%12.3f|\n";
  public static final String RESULT_S = "|%8s|%11s|%10s|%13s|%12s|%11s|%10s|%13s|%12s|\n";
  public static final String RESULTS_HEADER = String.format("|%8s|%49s|%49s|", "Size n", "Iterative", "Recursive");
  public static final String RESULTS_SUB_HEADER = String.format(RESULT_S, "", "Avg Op #", "Std Dev", "Avg Time", "Std Dev", "Avg Op #", "Std Dev", "Avg Time", "Std Dev");
}
