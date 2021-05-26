package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Service.BenhNhanService;
import Service.LichHenService;
import Service.NhanVienService;
import Service.PhieuDichVuService;
import Service.PhieuKhamService;
import enity.BenhNhan;
import enity.DichVu;
import enity.LichHen;
import enity.NhanVien;
import enity.PhieuKhambenh;
import enity.TaiKhoan;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;

public class GUIDatLichKham extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JComponent menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	
	private TaiKhoan mTaiKhoan;
	private NhanVien mNhanVien,mBacSy;
	private BenhNhan mBenhNhan;
	private BenhNhanService benhnhanservice;
	private NhanVienService nhanvienservice;
	private LichHenService lichhenservice;
	private PhieuKhamService phieuKhamService;
	
	private JPanel Jpanel_1;
	private JLabel lbldiaChiBN;
	private JTextField txtdiaChiBN;
	
	private JTextField txthoTenBN;
	private JLabel lblmaBN;
	private JButton btnhuy,btnthem;
	private JButton btnluu;
	private JComboBox comboBox,comboBox_1;
	
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	
	private DefaultTableModel datamodel; 
	private JScrollPane scrollPane;
	private JTable table;

	private List<BenhNhan> listBN;
	private List<NhanVien> listNV;
	private List<PhieuKhambenh> listpk;
	private PhieuKhambenh pkb;
 
	private JPanel panel;
	private JTextField textField;
	private JTextArea tattrieuchung,tatghichu;
	private JButton btncapnhat;

	
	/**
	 * Create the frame.
	 */
	public GUIDatLichKham(TaiKhoan taikhoan,NhanVien nhanvien) {
		this.mTaiKhoan=taikhoan;
		this.mNhanVien=nhanvien;
		this.benhnhanservice=new BenhNhanService();
		this.lichhenservice=new LichHenService();
		this.nhanvienservice = new NhanVienService();
		this.phieuKhamService=new PhieuKhamService();
		
		setTitle("Đặt lịch khám");
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1177, 700);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHpngBn = new JLabel("Đặt Lịch Khám");
		lblHpngBn.setBounds(304, 0, 436, 48);
		lblHpngBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHpngBn.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblHpngBn);
		
		
		
		Jpanel_1 = new JPanel();
		Jpanel_1.setBounds(28, 59, 1104, 93);
		contentPane.add(Jpanel_1);
		Jpanel_1.setBackground(SystemColor.inactiveCaptionBorder);
		Jpanel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin bệnh nhân", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Jpanel_1.setLayout(null);
				
				JLabel lblhoTenBN = new JLabel("Họ tên: ");
				lblhoTenBN.setBounds(33, 60, 86, 20);
				Jpanel_1.add(lblhoTenBN);
				lblhoTenBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				txthoTenBN = new JTextField();
				txthoTenBN.setBounds(152, 61, 268, 20);
				txthoTenBN.setEnabled(false);
				Jpanel_1.add(txthoTenBN);
				txthoTenBN.setUI(new HintTextFieldUI("					Nhập họ tên bệnh nhân. VD: Nguyễn Văn B", true, Color.GRAY));
				txthoTenBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txthoTenBN.setColumns(10);
				
				txtdiaChiBN = new JTextField();
				txtdiaChiBN.setBounds(742, 61, 268, 20);
				Jpanel_1.add(txtdiaChiBN);
				txtdiaChiBN.setUI(new HintTextFieldUI("					Nhập địa chỉ khách hàng. VD: Bình Thuận", true, Color.GRAY));
				txtdiaChiBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtdiaChiBN.setColumns(10);
				txtdiaChiBN.setEnabled(false);
				
				lbldiaChiBN = new JLabel("Địa chỉ:");
				lbldiaChiBN.setBounds(623, 60, 86, 20);
				Jpanel_1.add(lbldiaChiBN);
				lbldiaChiBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				lblmaBN = new JLabel("Mã bệnh nhân :");
				lblmaBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblmaBN.setBounds(33, 30, 86, 20);
				Jpanel_1.add(lblmaBN);
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();       
				String todayAsString = df.format(today);
				
				try {
					 listBN= benhnhanservice.GetAllBenhNhan();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 comboBox = new JComboBox();
				
				for(int i=0;i<listBN.size();i++)
					comboBox.addItem(listBN.get(i).getId());
				comboBox.setSelectedItem(null);
				comboBox.setBounds(152, 30, 268, 20);
				Jpanel_1.add(comboBox);
				
				JLabel lblsdT = new JLabel("Số điện thoại:");
				lblsdT.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblsdT.setBounds(623, 30, 86, 20);
				Jpanel_1.add(lblsdT);
				
				textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
				textField.setEnabled(false);
				textField.setColumns(10);
				textField.setBounds(742, 31, 268, 20);
				Jpanel_1.add(textField);
				
				
				
				
				String[]headers = {"Mã","Ghi Chú","Thời Gian", "Người khám","Bệnh nhân","Triệu Chứng","Hình thức","Trạng thái"};
				datamodel = new DefaultTableModel(headers,0);
				contentPane.add(scrollPane= new JScrollPane(table = new JTable(datamodel)));
				scrollPane.setBounds(51, 185, 1060, 109);
				table.setFont(new Font("Tahoma", Font.PLAIN, 12));
				scrollPane.setBackground(SystemColor.scrollbar);
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "Lịch khám bệnh ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBackground(SystemColor.inactiveCaptionBorder);
				panel_1.setBounds(28, 316, 1106, 187);
				contentPane.add(panel_1);
				
				listpk=new ArrayList<>();
				comboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						
								try {
									mBenhNhan=benhnhanservice.GetOneBenhNhan(Long.parseLong(comboBox.getSelectedItem().toString()));
								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
									
										txthoTenBN.setText(mBenhNhan.getTen());
										txtdiaChiBN.setText(mBenhNhan.getDiaChi());
										textField.setText(mBenhNhan.getSoDienThoai());
										removeTable();
										updateTableData();
							
					}
				});
				
				
				JLabel lblNewLabel_1 = new JLabel("Triệu chứng  :");
				lblNewLabel_1.setBounds(37, 76, 109, 19);
				panel_1.add(lblNewLabel_1);
				
				tattrieuchung = new JTextArea();
				tattrieuchung.setBounds(213, 73, 837, 46);
				panel_1.add(tattrieuchung);
				
				btnhuy = new JButton("Quay Lại");
				btnhuy.setIcon(new ImageIcon("Login-out-icon.png"));
				btnhuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnhuy.setBounds(977, 564, 155, 57);
				contentPane.add(btnhuy);
				
				btnluu = new JButton("Lưu");
				btnluu.setIcon(new ImageIcon("luu.png"));
				btnluu.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnluu.setBounds(767, 564, 155, 57);
				contentPane.add(btnluu);
				
				btnthem = new JButton("Thêm");
				btnthem.setIcon(new ImageIcon("sua.png"));
				btnthem.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnthem.setBounds(53, 564, 155, 57);
				contentPane.add(btnthem);
				
			comboBox.setEnabled(false);
			tattrieuchung.setEnabled(false);
			
			JLabel lblmaBN_1 = new JLabel("Chọn bác sỹ :");
			lblmaBN_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblmaBN_1.setBounds(35, 24, 143, 20);
			panel_1.add(lblmaBN_1);
			
			comboBox_1 = new JComboBox();
			
			listNV=new ArrayList<NhanVien>();
			try {
				listNV=nhanvienservice.GetNHanVienByRole((long) 2);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i=0;i<listNV.size();i++)
				comboBox_1.addItem(listNV.get(i).getTen());
		
			comboBox_1.setSelectedItem(null);
			comboBox_1.setEnabled(false);
			comboBox_1.setBounds(211, 24, 179, 20);
			panel_1.add(comboBox_1);
			
			comboBox_1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					for(int i =0;i<listNV.size();i++)
						if(comboBox_1.getSelectedItem().equals(listNV.get(i).getTen()))
							mBacSy=listNV.get(i);
				}
			});
			
			tatghichu = new JTextArea();
			tatghichu.setEnabled(false);
			tatghichu.setBounds(529, 24, 536, 38);
			panel_1.add(tatghichu);
			
			JLabel lblNewLabel_1_1 = new JLabel("Ghi chú  :");
			lblNewLabel_1_1.setBounds(440, 26, 81, 19);
			panel_1.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel = new JLabel("Trạng Thái :");
			lblNewLabel.setBounds(37, 125, 103, 25);
			panel_1.add(lblNewLabel);
			
			rdbtnNewRadioButton = new JRadioButton("Đang chờ khám");
			
			rdbtnNewRadioButton.setBounds(213, 126, 134, 23);
			panel_1.add(rdbtnNewRadioButton);
			
			 rdbtnNewRadioButton_1 = new JRadioButton("Đã khám");
			rdbtnNewRadioButton_1.setBounds(412, 126, 109, 23);
			panel_1.add(rdbtnNewRadioButton_1);
			
			 rdbtnNewRadioButton_2 = new JRadioButton("Vắng mặt");
			rdbtnNewRadioButton_2.setBounds(587, 126, 109, 23);
			panel_1.add(rdbtnNewRadioButton_2);
			btnluu.setEnabled(false);
			
			rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(rdbtnNewRadioButton.isSelected())
					{
						rdbtnNewRadioButton_1.setSelected(false);
						rdbtnNewRadioButton_2.setSelected(false);
					}
				}
			});
			rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(rdbtnNewRadioButton_1.isSelected())
					{
						rdbtnNewRadioButton.setSelected(false);
						rdbtnNewRadioButton_2.setSelected(false);
					}
				}
			});
			rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(rdbtnNewRadioButton_2.isSelected())
					{
						rdbtnNewRadioButton_1.setSelected(false);
						rdbtnNewRadioButton.setSelected(false);
					}
				}
			});
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(28, 163, 1104, 147);
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(null, "Danh sách lịch khám bệnh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBackground(SystemColor.inactiveCaptionBorder);
			contentPane.add(panel_2);
			
			btncapnhat = new JButton("Cập nhật");
			btncapnhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btncapnhat.setBounds(274, 564, 196, 57);
			contentPane.add(btncapnhat);
				
			btnhuy.addActionListener(this);
			btnluu.addActionListener(this);
			btnthem.addActionListener(this);
			btncapnhat.addActionListener(this);
			table.addMouseListener(this);
			
			btncapnhat.setEnabled(false);
			updateTableData();
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		btncapnhat.setEnabled(true);
		
		tatghichu.setText(table.getValueAt(row, 1).toString());
		tattrieuchung.setText(table.getValueAt(row, 5).toString());
		if(table.getValueAt(row, 7).toString().equals("Đã khám"))
		{
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(true);
			rdbtnNewRadioButton.setSelected(false);
		}
		else if(table.getValueAt(row, 7).toString().equals("Đang chờ khám"))
		{
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton.setSelected(true);
		}else {
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(true);
		}
		comboBox_1.setSelectedItem(table.getValueAt(row, 3).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		int ketqua=0;
		if(o==btnhuy)
		{
			dispose();
			GUIChucNang cn=new GUIChucNang(mTaiKhoan, mNhanVien);
			cn.setVisible(true);
		}else if(o==btnluu)
		{
			
			LichHen lichHen= new LichHen();
			LichHen lh=null;
			
	        try {
				lh=lichhenservice.GetLichHenBenhNhan(lichhenservice.doichuoitungay(java.util.Calendar.getInstance().getTime()), mBenhNhan.getId());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			lichHen.setBenhNhan(mBenhNhan);
			lichHen.setNhanvien(mBacSy);
			lichHen.setThoiGian(java.util.Calendar.getInstance().getTime());
			lichHen.setHinhThuc(false);
			lichHen.setTrieuChung(tattrieuchung.getText());
			lichHen.setGhiChu(tatghichu.getText());
			String trangthai="";
			if(rdbtnNewRadioButton.isSelected())
				trangthai="1";
			else if(rdbtnNewRadioButton_1.isSelected())
				trangthai="2";
			else if(rdbtnNewRadioButton_2.isSelected())
				trangthai="3";
			lichHen.setTrangThai(trangthai);
			if(lh==null)
			{
				int ketquaPost = 0;
				try {
					ketquaPost = lichhenservice.POSTLichHen(lichHen);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(ketquaPost==200)
				{
					
					JOptionPane.showMessageDialog(this,"Bạn vừa thêm lich hẹn khám thành công !","Chú ý",JOptionPane.CLOSED_OPTION);
					XoaRong();
					removeTable();
					updateTableData();
				}
			}
			else {
				JOptionPane.showMessageDialog(this,"Bệnh nhân này đã có lịch khám trong ngày rồi !","Chú ý",JOptionPane.CLOSED_OPTION);
				
			}
		}else if(o==btnthem)
		{
			if(btnthem.getText().equals("Thêm"))
			{
				comboBox.setEnabled(true);
				comboBox_1.setEnabled(true);
				tatghichu.setEnabled(true);
				tattrieuchung.setEnabled(true);
				btnluu.setEnabled(true);
				btnthem.setText("Hủy");
			}else if(btnthem.getText().equals("Hủy"))
			{
				comboBox.setEnabled(false);
				comboBox_1.setEnabled(false);
				tatghichu.setEnabled(false);
				tattrieuchung.setEnabled(false);
				btnluu.setEnabled(false);
				btnthem.setText("Thêm");
			}
			
		}else if(o==btncapnhat) {
			if(btncapnhat.getText().equals("Cập nhật"))
			{
				int KetQuaPUT=0;
				int row = table.getSelectedRow();
				LichHen lh=new LichHen();
				try {
					lh=lichhenservice.GetOneLichHen(Long.parseLong(table.getValueAt(row, 0).toString()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String trangthai="";
				if(rdbtnNewRadioButton.isSelected())
					trangthai="1";
				else if(rdbtnNewRadioButton_1.isSelected())
					trangthai="2";
				else if(rdbtnNewRadioButton_2.isSelected())
					trangthai="3";
				lh.setTrangThai(trangthai);
				
				try {
					 KetQuaPUT=lichhenservice.PUTLichHen(lh);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(KetQuaPUT==200) {
					JOptionPane.showMessageDialog(table,"Bạn vừa cập nhật trạng thái 1 lịch khám !","Chú ý",JOptionPane.CLOSED_OPTION);
					removeTable();
					updateTableData();
				}
			}
		}
		
	}
	public void updateTableData() 
	{
		// TODO Auto-generated method stub
		ArrayList<LichHen>list=new ArrayList<>();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date="";
	        date = formatter.format(java.util.Calendar.getInstance().getTime());
			list.addAll(lichhenservice.GetLichHenNhanVien(date,mNhanVien.getId()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null)
		{
			
			for (LichHen pk : list) {
				String hinhThuc=null;
				String trangthai=null;
				if(pk.isHinhThuc())
					hinhThuc="Đặt lịch";
				else
					hinhThuc="Khám trực tiếp";
				if(pk.getTrangThai().equals("1"))
					trangthai="Đang chờ khám";
				else if(pk.getTrangThai().equals("3"))
					trangthai="Vắng mặt";
				else 
					trangthai="Đã khám";
				String[] rowdata = { String.valueOf(pk.getMaLichHen()),pk.getGhiChu(),benhnhanservice.doichuoitungay(pk.getThoiGian()),pk.getNhanvien().getTen(),pk.getBenhNhan().getTen(),pk.getTrieuChung(),hinhThuc,trangthai};
				datamodel.addRow(rowdata);
			}
		}
	}
	public void removeTable() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
	}
	public void XoaRong() {
		tattrieuchung.setText("");
		tatghichu.setText("");
	}
}
