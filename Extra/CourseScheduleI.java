package Extra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] list = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (list[prerequisites[i][1]] == null) {
                list[prerequisites[i][1]] = new ArrayList<Integer>();
            }
            list[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            if (inDegree[i] == 0) {
                for (int j = 0; j < list[i].size(); j++) {
                    inDegree[(int) list[i].get(j)]--;

                    if (inDegree[(int) list[i].get(j)] == 0) {
                        queue.add((Integer) list[i].get(j));
                    }
                }

            } else {

                return false;
            }

        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

// Test Cases:

// 2
// [[1,0]]
// 4
// [[1,0],[2,0],[2,3],[3,1],[3,2]]
// 1
// []
// 3
// [[0,1],[0,2],[1,2]]
// 7
// [[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]
// 2
// [[0,1],[1,0]]
// 800
// [[695,229],[199,149],[443,397],[258,247],[781,667],[350,160],[678,629],[467,166],[500,450],[477,107],[483,151],[792,785],[752,368],[659,623],[316,224],[487,268],[743,206],[552,211],[314,20],[720,196],[421,103],[493,288],[762,24],[528,318],[472,32],[684,502],[641,354],[586,480],[629,54],[611,412],[719,680],[733,42],[549,519],[697,316],[791,634],[546,70],[676,587],[460,58],[605,530],[617,579],[484,89],[571,482],[767,200],[555,547],[771,695],[624,542],[708,551],[432,266],[656,468],[724,317],[423,248],[621,593],[781,399],[535,528],[578,12],[770,549],[576,295],[318,247],[400,372],[465,363],[786,482],[441,398],[577,411],[524,30],[741,540],[459,59],[758,96],[550,89],[402,295],[476,336],[645,346],[750,116],[551,207],[343,226],[568,498],[530,228],[525,84],[507,128],[526,210],[535,381],[635,330],[654,535],[710,275],[397,213],[412,44],[131,70],[508,49],[679,223],[519,11],[626,286],[242,160],[778,199],[606,281],[226,16],[340,46],[578,127],[212,208],[674,343],[778,108]]
// 10
// [[5,8], [3,5], [1,9], [4,5], [0,2], [7,8], [4,9]]
