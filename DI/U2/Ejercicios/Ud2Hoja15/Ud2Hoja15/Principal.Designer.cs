﻿namespace Ud2Hoja15
{
    partial class Principal
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            tsmiAdd = new ToolStripMenuItem();
            tsmiVer = new ToolStripMenuItem();
            tsmiBuscar = new ToolStripMenuItem();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { tsmiAdd, tsmiVer, tsmiBuscar });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(788, 24);
            menuStrip1.TabIndex = 1;
            menuStrip1.Text = "menuStrip1";
            // 
            // tsmiAdd
            // 
            tsmiAdd.Name = "tsmiAdd";
            tsmiAdd.Size = new Size(61, 20);
            tsmiAdd.Text = "Agregar";
            tsmiAdd.Click += tsmiAdd_Click;
            // 
            // tsmiVer
            // 
            tsmiVer.Name = "tsmiVer";
            tsmiVer.Size = new Size(35, 20);
            tsmiVer.Text = "Ver";
            tsmiVer.Click += tsmiVer_Click;
            // 
            // tsmiBuscar
            // 
            tsmiBuscar.Name = "tsmiBuscar";
            tsmiBuscar.Size = new Size(54, 20);
            tsmiBuscar.Text = "Buscar";
            tsmiBuscar.Click += tsmiBuscar_Click;
            // 
            // Principal
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(788, 464);
            Controls.Add(menuStrip1);
            IsMdiContainer = true;
            MainMenuStrip = menuStrip1;
            Name = "Principal";
            Text = "Principal";
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem tsmiAdd;
        private ToolStripMenuItem tsmiVer;
        private ToolStripMenuItem tsmiBuscar;
    }
}
