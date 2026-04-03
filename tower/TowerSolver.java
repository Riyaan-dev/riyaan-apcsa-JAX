package tower;

public class TowerSolver {

    private TowerModel model;

    public TowerSolver()
    {
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model, 0, 1, 2, model.height() - 1);
    }

    public void solve(TowerModel model, int start, int goal, int extra, int layer)
    {
        if (layer == 0)
        {
            model.move(start, goal);
            return;
        }

        solve(model, start, extra, goal, layer - 1);
        model.move(start, goal);
        solve(model, extra, goal, start, layer - 1);
    }
}