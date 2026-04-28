public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();
        if (type.equals("basic")) sorter.basicSort(arr);
        else sorter.advancedSort(arr);
        return System.nanoTime() - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        for (int size : sizes) {
            System.out.println("\n--- Size: " + size + " ---");
            int[] arr = sorter.generateRandomArray(size);

            // Тест Basic Sort
            int[] copy1 = arr.clone();
            long t1 = measureSortTime(copy1, "basic");
            System.out.println("Selection Sort: " + t1 + " ns");

            // Тест Advanced Sort
            int[] copy2 = arr.clone();
            long t2 = measureSortTime(copy2, "advanced");
            System.out.println("Quick Sort: " + t2 + " ns");

            // Тест Search (на отсортированном)
            long t3 = measureSearchTime(copy2, copy2[size/2]);
            System.out.println("Binary Search: " + t3 + " ns");
        }
    }
}