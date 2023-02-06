package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener{

 @Override
    public void onStart(ITestContext context){//but method tum testlerden once 1 kez cagrilir
     System.out.println("onStart-Tum testlerden once bir kere cagrilir : "+context.getName());// testcase adini al

    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("onFinish-Tum testlerden once bir kere cagrilir : "+context.getName());// testcase adini al
    }


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart-Her bir @Testden once tek bir kez cagrilir : "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess-Sadece PASS olan testerden SONRA tek bir kez cagrilir : "+result.getName());

    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("onTestFailure-Sadece FAIL olan testlerden SONRA tek bir kez cagrilir : "+result.getName());
        try {
            ReusableMethods.getScreenshot("Test-Case-FAIL-" + result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped-Sadece SKIP(atlanan) testlerden SONRA tek bir kez cagrilir : "+result.getName());
    }
}
