import java.util.*;

public class MergeIntervals {
    
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> finalList = new ArrayList<>();
        int[] newInterval = intervals[0];
        for(int[] interval : intervals){
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }else{
                newInterval = interval;
                finalList.add(newInterval);
            }
        }

        return finalList.toArray( new int[finalList.size()][]);
        
    }

    public static void main(String args[]){
        int[][] intervals = [[1,3],[2,6],[8,10],[15,18]];
        System.out.println(merge(intervals));
    }
}