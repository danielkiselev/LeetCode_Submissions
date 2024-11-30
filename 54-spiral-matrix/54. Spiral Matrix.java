class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> resL = new ArrayList<Integer>();
        int minx = 0;
        int miny = 0;
        try {
            int maxx = matrix[0].length;
            int maxy = matrix.length;
        } catch (Exception e) {
            return resL;
        }
        int maxx = matrix[0].length;
        int maxy = matrix.length;
        int total = maxx * maxy;
        int counter = 0;
        int indexOffSet = 0;
        while (counter < total) {
            int maxx1 = (maxx - 1) - (indexOffSet);
            int maxy1 = (maxy - 1) - (indexOffSet);
            if (counter + 1 == total) {
                resL.add(matrix[maxy / 2][maxx / 2]);
                return resL;
            }
            for (int x = minx + indexOffSet; x < maxx1; x++) {
                System.out.println(counter);
                resL.add(matrix[indexOffSet][x]);
                counter++;
                if (counter == total) {
                    return resL;
                }
            }
            for (int y = miny + indexOffSet; y < maxy1; y++) {
                System.out.println(counter);
                resL.add(matrix[y][maxx1]);
                counter++;
                if (counter == total) {
                    return resL;
                }
            }
            for (int x = maxx1; x >= (minx + 1) + indexOffSet; x--) {
                System.out.println(counter);
                resL.add(matrix[maxy1][x]);
                counter++;
                if (counter == total) {
                    return resL;
                }
            }
            for (int y = (maxy - 1) - (indexOffSet); y >= (miny + 1) + indexOffSet; y--) {
                System.out.println(counter);
                resL.add(matrix[y][indexOffSet]);
                counter++;
                if (counter == total) {
                    return resL;
                }
            }
            System.out.println(counter + "  end");
            indexOffSet++;
        }
        return resL;
    }
}