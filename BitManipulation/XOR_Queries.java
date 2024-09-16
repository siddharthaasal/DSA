package BitManipulation;


class XOR_Queries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixOfXOR = new int[arr.length];
        prefixOfXOR[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefixOfXOR[i] = prefixOfXOR[i-1] ^ arr[i];
        }

        int ans[] = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            int si = query[0];
            int ei = query[1];

            if (si == 0) {
                ans[i] = prefixOfXOR[ei];
            } else {
                // XOR from si to ei is prefixOfXOR[ei] ^ prefixOfXOR[si - 1]
                ans[i] = prefixOfXOR[ei] ^ prefixOfXOR[si - 1];
            }
        }
        return ans;
    }
}