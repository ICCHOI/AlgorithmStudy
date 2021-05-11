/* 스킬트리 https://programmers.co.kr/learn/courses/30/lessons/49993
   선행 스킬 순서를 담은 skill과 skill들의 모음을 담은 skill_trees 배열이 주어질 때,
   가능한 스킬 트리 개수를 반환하시오.
 */
class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill.length(); i++) {
            for (int j = 0; j < skill_trees.length; j++) {
                skill_trees[j] = skill_trees[j].replace(String.valueOf(skill.charAt(i)), String.valueOf(i));
            }
        }

        for (int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[A-Z]", "");
        }

        for (String skill_tree : skill_trees) {
            for (int j = 0; j < skill_tree.length(); j++) {
                if (Character.getNumericValue(skill_tree.charAt(j)) != j) {
                    answer++;
                    break;
                }
            }
        }

        return skill_trees.length - answer;
    }
}


//class Main {
//    public static void main(String[] args) {
//        SkillTree solution = new SkillTree();
//        System.out.println(solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
//    }
//}