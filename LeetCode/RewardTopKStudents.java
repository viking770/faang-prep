import java.util.*;

public class RewardTopKStudents {

    class InnerRewardTopKStudents {
        int id;
        int score;

        InnerRewardTopKStudents(int id, int score){
            this.id = id;
            this.score = score;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, 
        String[] negative_feedback, String[] report, int[] student_id, int k) {

            Set<String> pSet = new HashSet<String>(Arrays.asList(positive_feedback));
            Set<String> nSet = new HashSet<String>(Arrays.asList(negative_feedback));

            PriorityQueue<InnerRewardTopKStudents> priorityQueue = new PriorityQueue<>(
                (a,b)-> {
                        if(a.score!=b.score) 
                            return Integer.compare(b.score, a.score);
                        else 
                            return Integer.compare(a.id, b.id);
                        });
            
            for(int i=0; i<report.length;i++){
                int score = 0;
                String[] words = report[i].split(" ");
                for(String word : words){
                    if(pSet.contains(word))
                        score += 3;
                    if(nSet.contains(word))
                        score -= 1;
                }
                priorityQueue.add(new InnerRewardTopKStudents(student_id[i], score));
            }
            List<Integer> resultList = new ArrayList<>();
            while(!priorityQueue.isEmpty() && k>0){
                InnerRewardTopKStudents innerRewardTopKStudents = priorityQueue.poll();
                resultList.add(innerRewardTopKStudents.id);
                k--;
            }
            return resultList;
        }

      public static void main(String[] args) {
        RewardTopKStudents rewardTopKStudents = new RewardTopKStudents();
        String[] pf = {"smart","brilliant","studious"};
        String[] nf = {"not"};
        String[] report = {"this student is not studious","the student is not smart","this student is studious"};
        int[] sId = {4,2,10};
        List<Integer> topStudentList = rewardTopKStudents.topStudents(pf, nf, report, sId, 2);
        System.out.println(topStudentList.toString());
      }  
}