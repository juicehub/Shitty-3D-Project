import java.awt.Color;
import java.util.ArrayList;

public class Tree {

    Cube[] cubes = new Cube[22];

    double x, y, z;

    public Tree(double x, double y, double z, ArrayList<Cube> cubes) {
        this.x = x;
        this.y = y;
        this.z = z;

        Color brown = new Color(139, 69, 19);
        Cube a = new Cube(x, y, z, brown);
        Cube b = new Cube(x, y + 1, z, brown);
        Cube c = new Cube(x, y + 2, z, brown);
        Cube d = new Cube(x, y + 3, z, brown);
        Cube e = new Cube(x, y + 4, z, Color.green);
        Cube f = new Cube(x + 1, y + 4, z, Color.green);
        Cube g = new Cube(x + 1, y + 4, z + 1, Color.green);
        Cube h = new Cube(x, y + 4, z + 1, Color.green);
        Cube i = new Cube(x-1, y + 4, z-1, Color.green);
        Cube j = new Cube(x-1, y + 4, z + 1, Color.green);
        Cube k = new Cube(x + 1, y + 4, z-1, Color.green);
        Cube l = new Cube(x, y + 4, z-1, Color.green);
        Cube m = new Cube(x-1, y + 4, z, Color.green);
        Cube n = new Cube(x+  1, y + 3, z, Color.green);
        Cube o = new Cube(x + 1, y + 3, z + 1, Color.green);
        Cube p = new Cube(x, y+  3, z + 1, Color.green);
        Cube q = new Cube(x-1, y+ 3, z-1, Color.green);
        Cube r = new Cube(x-1, y+  3, z + 1, Color.green);
        Cube s = new Cube(x  + 1, y + 3, z-1, Color.green);
        Cube t = new Cube(x, y+  3,z -1, Color.green);
        Cube u = new Cube(x-1, y+3, z, Color.green);
        Cube v = new Cube(x, y+  5, z, Color.green);

        cubes.add(a);
        cubes.add(b);
        cubes.add(c);
        cubes.add(d);
        cubes.add(e);
        cubes.add(f);
        cubes.add(g);
        cubes.add(h);
        cubes.add(i);
        cubes.add(j);
        cubes.add(k);
        cubes.add(l);
        cubes.add(m);
        cubes.add(n);
        cubes.add(o);
        cubes.add(p);
        cubes.add(q);
        cubes.add(r);
        cubes.add(s);
        cubes.add(t);
        cubes.add(u);
        cubes.add(v);


        /**
         cubes[0] = a;
         cubes[1] = b;
         cubes[2] = c;
         cubes[3] = d;
         cubes[4] = e;
         cubes[5] = f;
         cubes[6] = g;
         cubes[7] = h;
         cubes[8] = i;
         cubes[9] = j;
         cubes[10] = k;
         cubes[11] = l;
         cubes[12] = m;
         cubes[13] = n;
         cubes[14] = o;
         cubes[15] = p;
         cubes[16] = q;
         cubes[17] = r;
         cubes[18] = s;
         cubes[19] = t;
         cubes[20] = u;
         cubes[21] = v;**/


    }

}
