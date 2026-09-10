class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
        
    }
     public long sumSubarrayMins(int[] arr) {
        long sum = 0;
        long mod = 1000000007;
        int n = arr.length;
        
        int[] pse = psee(arr, n);
        int[] nse = nseFind(arr, n);
        
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            
            // Calculate contribution with long to prevent integer overflow
            long totalWays = (left * right);
            long contribution = (totalWays * arr[i]);
            
            sum = (sum + contribution) ;
        }
        
        return  sum;
    }
    
    public int[] nseFind(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            // Strict inequality here to handle duplicates correctly
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] psee(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            // Non-strict inequality here
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

     public long sumSubarrayMaxs(int[] arr) {
        long sum = 0;
        long mod = 1000000007;
        int n = arr.length;
        
        int[] pse = pmee(arr, n);
        int[] nse = mseFind(arr, n);
        
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            
            // Calculate contribution with long to prevent integer overflow
            long totalWays = (left * right) ;
            long contribution = (totalWays * arr[i]) ;
            
            sum = (sum + contribution);
        }
        
        return  sum;
    }
    
    public int[] mseFind(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            // Strict inequality here to handle duplicates correctly
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] pmee(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            // Non-strict inequality here
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}