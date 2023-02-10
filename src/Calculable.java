import java.util.List;
import java.util.Map;

public interface Calculable {
    int calculateExpressionConsistingThreeOperands(List<Integer> operands, List<Character> operators, Map<Character, Integer> priorityOfSigns);
    int calculateExpressionConsistingTwoOperands(List<Integer> values, List<Character> operators);
}
