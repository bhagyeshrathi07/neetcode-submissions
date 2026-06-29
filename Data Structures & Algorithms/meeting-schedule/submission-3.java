/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        //pseudocode
        // 1. sort the intervals according to start time
        // 2. if start time of any meeting is between previous meeting interval return false
        // 3. else return true;

        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        for(int i = 1; i < intervals.size(); i++) {
            Interval curMeeting = intervals.get(i);
            Interval prevMeeting = intervals.get(i-1);
            if(prevMeeting.start <= curMeeting.start && curMeeting.start < prevMeeting.end) {
                return false;
            }
        }
        return true;
    }
}
