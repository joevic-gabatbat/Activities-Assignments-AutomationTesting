package exams;

public class Question7 {
    
    public static void main(String[] args)
    {
        int[] arr1 = { 1, 3, 5, 6 };
        int[] arr2 = { 0, 2, 6, 8, 9 };
 
        // Function Call
        merge(arr1, arr2, arr1.length, arr2.length);
 
        System.out.print("First Array: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
 
        System.out.println();
 
        System.out.print("Second Array: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
    
    private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
 
    private static void merge(int[] arr1, int[] arr2, int n, int m)
    {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap))
        {
            // comparing elements in the first array.
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap])
                {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
 
            // comparing elements in both arrays.
            for (j = gap > n ? gap - n : 0;
                 i < n && j < m;
                 i++, j++)
                if (arr1[i] > arr2[j])
                {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
 
            if (j < m)
            {
                // comparing elements in the second array.
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap])
                    {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }
    }
}
