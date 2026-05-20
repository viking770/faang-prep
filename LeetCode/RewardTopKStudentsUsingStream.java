import java.util.*;
import java.util.stream.Collectors;

public class RewardTopKStudentsUsingStream {

    record Student(int id, int points){}

    public List<Integer> topStudents(String[] positive_feedback, 
            String[] negative_feedback, String[] report, int[] student_id, int k) {

                Set<String> pSet = Arrays.stream(positive_feedback).collect(Collectors.toSet());
                Set<String> nSet = Arrays.stream(negative_feedback).collect(Collectors.toSet());
                List<Student> topStudents = new ArrayList<>();

                for(int i=0; i<report.length;i++){
                    int points = getPoints(report[i], pSet, nSet);
                    topStudents.add(new Student(student_id[i], points));
                }

                return topStudents.stream().sorted(Comparator.comparing(Student::points).reversed().thenComparing(Student::id))
                .map(Student::id).limit(k).toList();

            }

            public int getPoints(String report, Set<String> pSet, Set<String> nSet){
                int points = 0;
                for(String word : report.split(" ")){
                    if(pSet.contains(word)) points +=3;
                    if(nSet.contains(word)) points -=1;
                }
                return points;
            }

            public static void main(String[] args) {
                RewardTopKStudentsUsingStream rewardTopKStudentsUsingStream = new RewardTopKStudentsUsingStream();
                String[] pf = {"smart","brilliant","studious"};
                String[] nf = {"not"};
                String[] report = {"this student is not studious","the student is smart","this student is studious"};
                int[] sId = {4,2,10};
                List<Integer> topStudentList = rewardTopKStudentsUsingStream.topStudents(pf, nf, report, sId, 2);
                System.out.println(topStudentList.toString());
            }
    
}
