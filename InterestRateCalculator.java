import java.text.NumberFormat;

public class InterestRateCalculator {

    public static void main(String[] args) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(3);
        // 贷款总额度
        int loanLimit = 50000;
        // 分期数量
        int stageNumber = 24;
        // 每月需还利息金额
        double interest = 81.7;
        // 每月需还款本金金额
        double moneyOfMonth = (double) loanLimit / stageNumber;
        // 理财收益率
        double yieldRate = 0.04;
        // 理财总收益
        double countIncome = 0;
        // 贷款利率总和
        double countRate = 0;
        for (int i = stageNumber; i > 0; i--) {
            double a = interest / (moneyOfMonth * i);
//            System.out.println("第" + (25 - i) + "个月,月利率为：" + percentInstance.format(a) + ";年利率为:" + percentInstance.format(a * 12) + ";加权后的平均年利率：" + percentInstance.format(a * 12 / 24 * i));
            System.out.println("第" + (stageNumber + 1 - i) + "个月,月利率为：" + percentInstance.format(a) + ";年利率为:" + percentInstance.format(a * 12));
            countRate += a;
        }
        System.out.println("平均月利率为：" + percentInstance.format(countRate / stageNumber) + "平均年利率为" + percentInstance.format(countRate / 2));


        System.out.println("按照4%年利率理财来算");
        for (int i = stageNumber; i > 0; i--) {
            double a = (moneyOfMonth * i) * yieldRate / 12;
            System.out.println("第" + (stageNumber + 1 - i) + "个月,月收益为：" + a);
            countIncome += a;
        }
        System.out.println("最终总利息为：" + interest * stageNumber + "; 若将钱拿来用作4%收益的投资，获取的收入为:" + countIncome);


        //重置总收益
        countIncome = 0;
        System.out.println("按照4%年利率理财来算:若考虑月度复利");
        double principal = moneyOfMonth * stageNumber;
        for (int i = stageNumber; i > 0; i--) {
            System.out.println("第" + (stageNumber + 1 - i) + "个月,月收益为：" + principal * yieldRate / 12);
            countIncome += principal * yieldRate / 12;
            // 总额减去每个月去掉的本金再加上当月产生的利益，因为需要复利
            principal = principal - moneyOfMonth - interest + principal * yieldRate / 12;

        }
        System.out.println("最终总利息为：" + interest * stageNumber + "; 若将钱拿来用作4%收益的投资，获取的收入为:" + countIncome);

    }


}
