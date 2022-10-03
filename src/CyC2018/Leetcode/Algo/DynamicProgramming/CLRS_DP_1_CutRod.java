package CyC2018.Leetcode.Algo.DynamicProgramming;

/**
 *
 * 本次介绍一个非常经典的问题，算法导论 CLRS 中动态规划这一章里的第一个题
 * Cut Rod 钢条切割问题
 *
 * （该题非常经典，01背包等等问题都是在在此题基础之上）
 *
 * 钢条切割，经典中的经典
 *
 * **/

public class CLRS_DP_1_CutRod {

}

/**
    int CutRod(const std::vector<int> &p, const int &n)
    {
        if (n == 0)
        {
            return 0;
        }

        int q = INT8_MIN;

        for (auto i = 1; i <= n; ++i)
        {
            q = std::max(q, p.at(i) + CutRod(p, n - i));
        }

        return q;
    }
 **/

/**
// Memoized version of cut_rod
int MemoizedCutRodAux(const std::vector<int> &p, const int &n, std::vector<int> &r)
{
    if (r.at(n) >= 0)
    {
        return r.at(n);
    }

    int q = 0;
    if (n == 0)
    {}
    else
    {
        q = INT8_MIN;
        for (auto i = 1; i <= n; ++i)
        {
            q = std::max(q, p.at(i) + MemoizedCutRodAux(p, n - i, r));
        }
    }

    r.at(n) = q;

    return q;
}
**/


/**
int BottomUpCutRod(const std::vector<int> &p, const int &n)
{
    std::vector<int> r{0};
    for (auto j = 1; j <= n; ++j)
    {
        int q = INT8_MIN;
        for (auto i = 1; i <= j; ++i)
        {
            q = std::max(q, p.at(i) + r.at(j - i));
        }
        r.push_back(q);
    }
    return r.at(n);
}**/