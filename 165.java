class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int max = Math.max(str1.length,str2.length);
        for(int i=0;i<max;i++){
            int num1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
            int num2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        String version1 = "1.2.3";
        String version2 = "1.2.3";
        
        // Compare the versions
        int result = solution.compareVersion(version1, version2);
        
        // Output the result
        System.out.println("Comparison result: " + result); // Expected output: 0 (versions are equal)
    }
}
