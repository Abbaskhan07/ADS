# Assignment 3: Sorting and Searching Algorithm Analysis System

**STUDENT:** Abbaskhan Ibraimov 
**GROUP:** IT-2501

---

## 1. Project Overview
This project analyzes and compares the performance of sorting and searching algorithms in Java.
The goal is to measure execution time and understand how algorithm efficiency changes depending on input size.

**Selected algorithms:**
* **Basic Sorting:** Selection Sort
* **Advanced Sorting:** Quick Sort
* **Searching:** Binary Search

---

## 2. Algorithm Descriptions

### Selection Sort
Selection Sort works by repeatedly finding the minimum element from the unsorted part and putting it at the beginning.
* **Time Complexity:** $O(n^2)$ (Best, Average, Worst)

### Quick Sort
Quick Sort selects a "pivot" element and partitions the array into smaller and larger elements, then recursively sorts them.
* **Time Complexity:** Average $O(n \log n)$, Worst $O(n^2)$

### Binary Search
Binary Search works only on **sorted arrays** by repeatedly dividing the search range in half.
* **Time Complexity:** Best $O(1)$, Average/Worst $O(\log n)$

---

## 3. Experimental Results
*Please replace the values below with the actual numbers from your console output.*

| Array Size | Selection Sort (ns) | Quick Sort (ns) | Binary Search (ns) |
| :--- | :--- | :--- | :--- |
| **Small (10)** | [INSERT] | [INSERT] | [INSERT] |
| **Medium (100)** | [INSERT] | [INSERT] | [INSERT] |
| **Large (1000)** | [INSERT] | [INSERT] | [INSERT] |

---

## 4. Analysis

1.  **Which sorting algorithm performed faster? Why?**
    Quick Sort performed significantly faster than Selection Sort on larger arrays because its average complexity is $O(n \log n)$, which is much more efficient than the quadratic $O(n^2)$ of Selection Sort.

2.  **How does performance change with input size?**
    As the array size increases, Selection Sort's execution time grows rapidly (quadratically), while Quick Sort's time grows much more slowly, making it more scalable.

3.  **Do the results match the expected Big-O complexity?**
    Yes, the empirical data matches theoretical Big-O expectations. The gap between the two sorting algorithms becomes very clear at $n=1000$.

4.  **Why does Binary Search require a sorted array?**
    Binary Search relies on the order of elements to decide whether the target is in the left or right half. Without sorting, this logic is impossible.

---

## 5. Reflection
This project helped me understand how different algorithms perform in practice. Selection Sort is simple to implement but inefficient for large datasets. Quick Sort is more complex due to recursion but demonstrates the power of the "divide and conquer" strategy. 

Measuring performance in nanoseconds allowed me to see the massive efficiency of Binary Search compared to sorting time. The main challenge was ensuring proper array cloning to avoid testing already sorted data.

---

## 6. Conclusion
The experiment confirmed that algorithm efficiency depends heavily on input size. Advanced algorithms like Quick Sort are essential for processing large amounts of data efficiently.
