namespace Ud2Hoja13
{
    public partial class Form1 : Form
    {
        private ListViewItemComparer lvis;
       
        public Form1()
        {
            InitializeComponent();
            cargarArbol();
            cargarLista();
        }



        private void cargarArbol()
        {
            treeView1.ImageList = imageList;//Asignamos la lista de im�genes al control TreeView
            treeView1.BeforeExpand += treeView1_BeforeExpand;//Asignamos el evento BeforeExpand al control TreeView
            treeView1.AfterSelect += treeView1_AfterSelect;//Asignamos el evento AfterSelect al control TreeView

            TreeNode nodoRaiz = new TreeNode("C:\\", 0, 1);//Creamos el nodo ra�z con la etiqueta "C:" y la imagen correspondiente
            nodoRaiz.Tag = new DirectoryInfo("C:\\");//Asignamos al nodo ra�z el directorio ra�z "C:"
            nodoRaiz.Nodes.Add(new TreeNode());//A�adimos un nodo hijo vac�o al nodo ra�z
            treeView1.Nodes.Add(nodoRaiz);//A�adimos el nodo ra�z al control TreeView
        }

        private void treeView1_BeforeExpand(object sender, TreeViewCancelEventArgs e)
        {
            TreeNode node = e.Node;//Nodo que se va a expandir 
            if (node.Nodes[0].Text == "" && node.Nodes.Count == 1)//Si el nodo hijo est� vac�o y no tiene m�s nodos hijos
            {
                node.Nodes.Clear();//Limpiamos los nodos hijos
                DirectoryInfo directory = (DirectoryInfo)node.Tag;//Directorio asociado al nodo que se va a expandir
                try
                {
                    foreach (DirectoryInfo d in directory.GetDirectories())//Recorremos los subdirectorios del directorio
                    {
                        TreeNode nuevoNodo = new TreeNode(d.Name, 0, 1);//Creamos un nuevo nodo con el nombre del subdirectorio y la imagen correspondiente 
                        nuevoNodo.Tag = d;//Asignamos al nodo el subdirectorio
                        nuevoNodo.Nodes.Add(new TreeNode());//A�adimos un nodo hijo vac�o al nodo
                        node.Nodes.Add(nuevoNodo);//A�adimos el nodo al nodo que se va a expandir
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
            }
        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            listView1.SmallImageList = imageList;//Asignamos la lista de im�genes al control ListView
            DirectoryInfo directory = (DirectoryInfo)e.Node.Tag;//Directorio asociado al nodo seleccionado
            listView1.Items.Clear();//Limpiamos los elementos del control ListView

            try
            {
                foreach (DirectoryInfo d in directory.GetDirectories())//Recorremos los subdirectorios del directorio
                {
                    ListViewItem item = new ListViewItem(d.Name, 0);//Creamos un nuevo elemento con el nombre del subdirectorio y la imagen correspondiente
                    item.SubItems.Add(d.LastWriteTime.ToString());//A�adimos la fecha de modificaci�n del subdirectorio
                    item.SubItems.Add("");//A�adimos un subelemento vac�o
                    listView1.Items.Add(item);//A�adimos el elemento al control ListView
                }

                foreach (FileInfo f in directory.GetFiles())//Recorremos los archivos del directorio
                {
                    
                    ListViewItem item = new ListViewItem(f.Name, 2);//Creamos un nuevo elemento con el nombre del archivo y la imagen correspondiente
                    item.SubItems.Add(f.LastWriteTime.ToString());//A�adimos la fecha de modificaci�n del archivo
                    item.SubItems.Add(f.Length.ToString());//A�adimos el tama�o del archivo
                    listView1.Items.Add(item);//A�adimos el elemento al control ListView
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void cargarLista()
        {
            lvis = new ListViewItemComparer();//Creamos un objeto de la clase ListViewItemComparer
            listView1.ListViewItemSorter = lvis;//Asignamos el objeto al control ListView

            listView1.View = View.Details;//Establecemos el modo de visualizaci�n de la lista
            listView1.Columns.Add("Nombre", 150);//A�adimos una columna con el nombre "Nombre" y un ancho de 150 p�xeles
            listView1.Columns.Add("Fecha de modificaci�n", 150);//A�adimos una columna con el nombre "Fecha de modificaci�n" y un ancho de 150 p�xeles
            listView1.Columns.Add("Tama�o", 150);//A�adimos una columna con el nombre "Tama�o"
            listView1.ColumnClick += listView1_ColumnClick;//Asignamos el evento ColumnClick al control ListView
        }
               
        private void listView1_ColumnClick(object sender, ColumnClickEventArgs e)
        {
            if(e.Column == lvis.Col)
            {
                lvis.Order = lvis.Order == SortOrder.Ascending? SortOrder.Descending : SortOrder.Ascending;
            }
            else
            {
                lvis.Col = e.Column;
                lvis.Order = lvis.Order == SortOrder.Ascending ? SortOrder.Descending : SortOrder.Ascending;
            }

            listView1.Sort();
        }
    }
}
