public class IIE06 {

	private GTerm gt;
	private int currentNum;
	private int maxNum;
	private String[] Name;
	private String[] Team;
	private int[] age;
	private float[] Height;
	private char[] CurrentPlayer;
	private String column;

	public IIE06() {
		
		// Gterm window creation and style
		this.gt = new GTerm(620, 500);
		this.gt.setBackgroundColor(213, 242, 238);
		this.gt.setFontSize(16);
	
		// Intialising the variables
		this.maxNum = 1;
		this.currentNum = 0;
		this.column = "Name\tTeam\tage\tHeight\tCurrent player (Y/N)";
		// Declarations
		// creates and allocates memory
		this.Name = new String[this.maxNum];
		this.Team = new String[this.maxNum];
		this.age = new int[this.maxNum];
		this.Height = new float[this.maxNum];
		this.CurrentPlayer = new char[this.maxNum];

		//

		this.gt.addTable(600, 300, column);
		this.gt.println(" ");
		this.gt.println("ENTER: Name,Team,age,Height,Current player (Y/N)");
		this.gt.addTextArea("", 300, 100);
		this.gt.addButton("Add", this, "addRecord");

	}
	// This method clears rows the table

	public void refreshTable() {
		// clears the rows of the table
		this.gt.clearRowsOfTable(0);
		int i = 0;
		while (i < this.currentNum) {
			// currentNum loops adds data to table
			String message = this.Name[i] + "\t" + this.Team[i] + "\t" + this.age[i] + "\t" + this.Height[i] + "\t"
					+ this.CurrentPlayer[i];
			this.gt.addRowToTable(0, message);
			i++;

		}
	}

	public void addRecord() {
		if (this.currentNum >= this.maxNum) {
			this.maxNum *= 2;
			this.gt.showMessageDialog("Expanding to " + this.maxNum);

			String[] longerName = new String[this.maxNum];
			String[] longerTeam = new String[this.maxNum];
			int[] longerAge = new int[this.maxNum];
			float[] longerHeight = new float[this.maxNum];
			char[] longerCp = new char[this.maxNum];

			int j = 0;

			while (j < this.currentNum) {
				longerName[j] = this.Name[j];
				longerTeam[j] = this.Team[j];
				longerAge[j] = this.age[j];
				longerHeight[j] = this.Height[j];
				longerCp[j] = this.CurrentPlayer[j];

				j++;
			}
			this.Name = longerName;
			this.Team = longerTeam;
			this.age = longerAge;
			this.Height = longerHeight;
			this.CurrentPlayer = longerCp;

		}
		String Userinput = this.gt.getTextFromEntry(0);
		String[] AthDet = Userinput.split(",");

		String Name = AthDet[0];
		String Team = AthDet[1];
		int Age = Integer.parseInt(AthDet[2]);
		float Height = Float.parseFloat(AthDet[3]);
		char CurrentPlayer = AthDet[4].charAt(0);

		// validations 
		//if left blank to renter values 
		//if less than 1 or 0 to renter values
		while (Name.isBlank())
			this.Name[this.currentNum] = this.gt.getInputString("Cannot leave blank");
		while (Team.isBlank())
			this.Team[this.currentNum] = this.gt.getInputString("Cannot leave blank");
		while (Age < 1)
			this.age[this.currentNum] = Integer.parseInt(this.gt.getInputString("Must enter an age greater than 0"));
		while (Height < 0)
			this.Height[this.currentNum] = Float.parseFloat(this.gt.getInputString("Re-enter a valid number"));

		this.Name[this.currentNum] = AthDet[0];
		this.Team[this.currentNum] = AthDet[1];
		this.age[this.currentNum] = Integer.parseInt(AthDet[2]);
		this.Height[this.currentNum] = Float.parseFloat(AthDet[3]);
		this.CurrentPlayer[this.currentNum] = AthDet[4].charAt(0);
		this.currentNum += 1;

		this.refreshTable();

	}

	public static void main(String[] args) {
		IIE06 IIE06Obj;
		IIE06Obj = new IIE06();

	}
}
