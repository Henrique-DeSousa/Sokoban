package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.utils.Point2D;

public class ObjectCreation{

	public static Objects readChar(char keyletter, int x, int y){

		switch(keyletter) {
		case 'C':
			Box b = new Box (new Point2D (x,y), "Key", 2);
			return b;
		case '#':
			Wall w = new Wall(new Point2D(x,y), "Wall", 2);
			return w;
		case 'O':
			Pitfall p = new Pitfall(new Point2D(x,y), "Hole", 0);
			return p;
		case 'b':
			Battery btr = new Battery(new Point2D(x,y), "Apple", 1);
			return btr;
		case 'X':
			Target X = new Target(new Point2D(x,y), "Chest", 0);
			return X;
		case 'p':
			SmallStone sr = new SmallStone(new Point2D(x,y),"SmallRock", 2);
			return sr;
		case 'P':
			BigStone br = new BigStone(new Point2D(x,y), "BigRock", 2);
			return br;
		case 'E':
			Forklift f = new Forklift(new Point2D(x,y), "Empilhadora_U", 2);
			return f;
		case '%':
			DamagedWall dw = new DamagedWall(new Point2D(x,y), "CrackedWall", 2);
			return dw;
		case 'm':
			Hammer h = new Hammer(new Point2D(x,y), "Hammer", 1);
			return h;
		case 'g':
			Ice i = new Ice(new Point2D(x,y), "Ice", 0);
			return i;
		case 't':
			Teleport t = new Teleport(new Point2D(x,y), "Blue_Portal", 0);
			return t;
		case 'T':
			Teleport t2 = new Teleport(new Point2D(x,y),"Green_Portal",0);
			return t2;
		case 'v':
			Void v = new Void(new Point2D(x,y), "Void", 2);
			return v;
	}
		return null;
	}


}

