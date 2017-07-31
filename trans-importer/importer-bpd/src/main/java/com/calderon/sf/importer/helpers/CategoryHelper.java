package com.calderon.sf.importer.helpers;

import com.calderon.sf.commons.persistence.enums.TranTypeEnum;
import com.calderon.sf.api.reader.Transaction;

/**
 * Created by Nathaniel on 6/10/2017.
 */
public class CategoryHelper {

    private static final int defaultExpenseCategory = 2;
    private static final int defaultIncomeCategory = 100;
    /*private static final List<TranCategoryEntity> categories;*/
    /*static {
        categories = CategoryDAO.getAllChildCategories();
    }*/
    public static int matchCategory (Transaction tran) {
        /*Optional<TranCategoryEntity> other = categories.stream()
                .filter(c -> c.getName().equals(defaultCategory))
                .findFirst();*/

        return tran.getType() == TranTypeEnum.DEBIT? defaultIncomeCategory: defaultExpenseCategory;
        //return other.orElseThrow(() -> new IllegalStateException("No categories exist. This method cannot return null."));
    }

}
