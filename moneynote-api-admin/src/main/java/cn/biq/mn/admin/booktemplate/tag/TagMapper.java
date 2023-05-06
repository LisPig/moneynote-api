package cn.biq.mn.admin.booktemplate.tag;

public class TagMapper {

    public static TagDetails toDetails(Tag entity) {
        if (entity == null) return null;
        var details = new TagDetails();
        details.setId(entity.getId());
        if (entity.getParent() != null) {
            details.setParentId(entity.getParent().getId());
        }
        details.setName(entity.getName());
        details.setNotes(entity.getNotes());
        details.setCanExpense(entity.getCanExpense());
        details.setCanIncome(entity.getCanIncome());
        details.setCanTransfer(entity.getCanTransfer());
        return details;
    }

}
