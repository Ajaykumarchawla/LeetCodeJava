package Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomII {
    public int minimumMeetingRooms(int[][] meetings) {
        Arrays.sort(meetings, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        List<Integer> rooms = new ArrayList<>();
        for (var meeting : meetings) {
            int scheduled = 0;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i) < meeting[0]) {
                    rooms.set(i, Math.max(rooms.get(i), meeting[1]));
                    scheduled = 1;
                    break;
                }
            }
            if (scheduled == 0) {
                rooms.add(meeting[1]);
            }
        }

        return rooms.size();
    }
}
