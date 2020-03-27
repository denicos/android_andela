using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace exam_center
{
    public partial class index : Form
    {
        utilities utility = new utilities();
        public index()
        {
            InitializeComponent();
        }

        private void bunifuThinButton21_Click(object sender, EventArgs e)
        {
            utility.ClearPanel(panel1);
            panel1.Controls.Add(new usercontrols.loginx());
        }

        private void bunifuThinButton22_Click(object sender, EventArgs e)
        {
            utility.ClearPanel(panel1);
            panel1.Controls.Add(new usercontrols.signup());
        }
    }
}
