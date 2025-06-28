package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.TextBoxPage;
import com.framework.utils.PageActionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    @Test
    public void testTextBoxFormSubmission() {
        PageActionUtils actions = new PageActionUtils();
        TextBoxPage textBox = new TextBoxPage(actions);

        textBox.open();
        textBox.enterFullName("Abdul Mateen");
        textBox.enterEmail("abdul.mateen@testmail.com");
        textBox.enterCurrentAddress("Hyderabad, India");
        textBox.enterPermanentAddress("Bangalore, India");
        textBox.clickSubmit();

        Assert.assertTrue(textBox.isOutputVisible(), "Form output not displayed after submission");
    }
}