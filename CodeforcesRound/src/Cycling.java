import java.util.*;

public class Cycling {

    static int getOperationCost(List<Integer> nums, int position) {
        int lastIdx = nums.size() - 1;

        if (position == lastIdx || position == 0) {
            return (position == lastIdx ? nums.get(position) : Math.min(nums.get(0), nums.get(1) + 1));
        }

        int[] candidates = { nums.get(position), nums.get(position + 1) + 1, nums.get(position - 1) + 1 };
        int optimal = Arrays.stream(candidates).min().getAsInt();

        if (optimal == nums.get(position + 1) + 1) {
            Collections.swap(nums, position, position + 1);
        } else if (optimal == nums.get(position - 1) + 1 && optimal != nums.get(position)) {
            Collections.swap(nums, position, position - 1);
        }

        return optimal;
    }

    static long evaluateMinimumCost(List<Integer> list, int pivotIndex) {
        int size = list.size();
        List<Integer> modified = new ArrayList<>(list);
        Collections.swap(modified, pivotIndex, size - 1);

        long totalCost = size - 1L - pivotIndex;
        for (int index = size - 1; index >= 0; --index) {
            totalCost += getOperationCost(modified, index);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalItems = scanner.nextInt();

        List<Integer> dataSequence = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            dataSequence.add(scanner.nextInt());
        }

        long minimalCost = Long.MAX_VALUE;
        for (int pos = 0; pos < totalItems; pos++) {
            long currentCost = evaluateMinimumCost(dataSequence, pos);
            minimalCost = Math.min(minimalCost, currentCost);
        }

        System.out.println(minimalCost);
    }
}
