/**
 * Financial class containing utility methods for financial calculations
 */
public class Financial {
    /**
     * Calculates a percentage of a given amount
     * @param percentage The percentage to calculate (e.g., 3 for 3%)
     * @param amount The amount to calculate the percentage of
     * @return The calculated percentage amount
     */
    public static double percentOf(double percentage, double amount) {
        return (percentage / 100.0) * amount;
    }
} 