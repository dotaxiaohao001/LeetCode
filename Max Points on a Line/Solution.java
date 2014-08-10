import java.util.HashMap;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
//  class Point {
//      int x;
//      int y;
//      Point() { x = 0; y = 0; }
//      Point(int a, int b) { x = a; y = b; }
//  }
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        if(points.length < 3)
            return points.length;
        int max = 0;
        // center point i
        for(int i = 0; i < points.length - 1; ++i) {
            HashMap<Double, Integer> ratioMap = new HashMap<Double, Integer>();
            int samePointNum = 0; // the number of points with same position at point[i]
            double ratio = 0.0;
            int maxOthers = 1; // max number of points with the ratio except duplicates center points
            //default value use 1 is used for counting the center point first// in case of all same 
            for(int j = i + 1; j < points.length; ++j) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePointNum++;
                    continue;// important !! here should loop out otherwise will check last ratio
                }
                else if(points[i].x == points[j].x) // use the max to represent infinit
                    ratio = Double.MAX_VALUE;
                else if(points[i].y == points[j].y) // +0.0 is not the same with -0.0
                    ratio = 0.0;
                else {
                    // can't conver type after get the result. cause it just equal to int
                    ratio = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                }

                //add into map 
                if(ratioMap.containsKey(ratio)) {
                    ratioMap.put(ratio, ratioMap.get(ratio) + 1);
                }
                else {
                    ratioMap.put(ratio, 2); // default is 2 cause center point + point[j]
                }
            }
// not good there might be one case of all same points
//            for(int num : ratioMap.value()) {
//                if(num + samePointNum > max)
//                    max = num + samPointNum;
//            }
            for(int num: ratioMap.values()) {
                if(num > maxOthers)
                  maxOthers = num;
            }
            
            max = Math.max(max, maxOthers + samePointNum);
        }
        return max;
    }
//    
//    public static void main(String args[]) {
//        Solution s = new Solution();
//        Point p1 = s.new Point(0,0);
//        Point p2 = s.new Point(1,1);
//        Point p3 = s.new Point(0,0);
//        Point[] ps = {p1,p2,p3};
//        System.out.println(s.maxPoints(ps));
//    }
}
