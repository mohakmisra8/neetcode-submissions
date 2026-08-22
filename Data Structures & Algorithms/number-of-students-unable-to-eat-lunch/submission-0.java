class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> q = new LinkedList<>();
        for(int s:students) {
            q.offer(s);
        }

        int res = n;
        for(int sandwich:sandwiches) {
            int count = 0;
            while(count < n && q.peek() != sandwich) {
                q.offer(q.poll());
                count++;
            }
            if(q.peek() == sandwich) {
                q.poll();
                res--;
                
            } else{
                break;
            }
        }

        return res;
        
    }
}