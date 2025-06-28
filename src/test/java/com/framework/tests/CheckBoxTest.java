package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.CheckBoxPage;
import com.framework.utils.PageActionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {
    @Test
    public void testCheckBoxSelection() {
        PageActionUtils actions = new PageActionUtils();
        CheckBoxPage checkBox = new CheckBoxPage(actions);

        checkBox.open();
        checkBox.expandTree();
        checkBox.checkHomeOption();

        Assert.assertTrue(checkBox.isChecked("home"), "Checkbox not selected properly.");
    }
}