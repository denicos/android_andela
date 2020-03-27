using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System.Windows.Forms;

namespace exam_center
{
    public partial class Form1 : Form

    {
        int _charIndex = 0;
        string _text = "ST LAWRENCE UNIVERSITY";
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            _charIndex = 0;
            label1.Text = string.Empty;
            Thread t = new Thread(new ThreadStart(this.TypeWriterText));
            t.Start();
        }
        private void TypeWriterText()
        {
            while(_charIndex < _text.Length)
            {
                Thread.Sleep(500);
                label1.Invoke(new Action(() =>
                {
                    label1.Text += _text[_charIndex];
                }));
                _charIndex++;
            }
        }

        private void bunifuImageButton1_Click(object sender, EventArgs e)
        {
            index ind = new index();
            ind.Show();
            this.Hide();
        }
    }
}
