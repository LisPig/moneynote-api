package cn.biq.mn.admin.booktemplate.category;

import lombok.Getter;
import lombok.Setter;
import cn.biq.mn.base.tree.TreeNode;

@Getter @Setter
public class CategoryDetails extends TreeNode<CategoryDetails> {

    private CategoryType type;
    private String notes;
    private Boolean canExpense;
    private Boolean canIncome;

}
