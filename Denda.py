import tkinter as tk
from tkinter import messagebox, ttk
import time
import json


class ReturnAndFineSystem:
    def __init__(self, root):
        """
        Inisialisasi sistem denda dan pengembalian buku.

        Parameters:
            root (tk.Tk): Window utama aplikasi.
        """
        self.root = root
        self.root.title("Sistem Denda dan Pengembalian")
        self.root.geometry("600x400")

        self.loadData()  # Memuat data peminjaman buku

        self.finePerDay = 5000  # Denda per hari keterlambatan
        self.maxExtensionDays = 7  # Maksimal perpanjangan 7 hari

        # GUI Elements
        ttk.Label(root, text="Sistem Denda dan Pengembalian", font=("Arial", 14)).pack(pady=10)
        ttk.Button(root, text="Lihat Denda", command=self.viewPenalty).pack(pady=5)
        ttk.Button(root, text="Pengembalian Buku", command=self.returnBookWindow).pack(pady=5)

    def loadData(self):
        """
        Memuat data peminjaman buku dari file JSON.
        Jika file tidak ditemukan, buat data default.
        """
        try:
            with open("book_data.json", "r") as file:
                self.bookData = json.load(file)
        except FileNotFoundError:
            self.bookData = {}
            self.saveData()

    def saveData(self):
        """ Menyimpan data peminjaman buku ke file JSON. """
        with open("book_data.json", "w") as file:
            json.dump(self.bookData, file, indent=4)

    def viewPenalty(self):
        """ Menampilkan daftar buku yang memiliki denda. """
        penaltyWindow = tk.Toplevel(self.root)
        penaltyWindow.title("Denda Buku")
        penaltyWindow.geometry("500x300")

        columns = ("ID Buku", "Judul", "Denda (IDR)")
        tree = ttk.Treeview(penaltyWindow, columns=columns, show="headings")
        for col in columns:
            tree.heading(col, text=col)
            tree.column(col, width=150, anchor="center")

        tree.pack(fill="both", expand=True)

        for bookId, bookInfo in self.bookData.items():
            if bookInfo["fine"] > 0:
                tree.insert("", "end", values=(bookId, bookInfo["title"], bookInfo["fine"]))

        ttk.Button(penaltyWindow, text="Tutup", command=penaltyWindow.destroy).pack(pady=10)

    def returnBookWindow(self):
        """ Membuka window untuk pengembalian buku. """
        returnWindow = tk.Toplevel(self.root)
        returnWindow.title("Pengembalian Buku")
        returnWindow.geometry("400x300")

        ttk.Label(returnWindow, text="Masukkan ID Buku:", font=("Arial", 12)).pack(pady=10)
        entryId = ttk.Entry(returnWindow)
        entryId.pack()

        frameButtons = ttk.Frame(returnWindow)
        frameButtons.pack(pady=10)

        ttk.Button(frameButtons, text="Cek Info Buku", command=lambda: self.checkBookInfo(entryId.get())).pack(side='left', padx=5)
        ttk.Button(frameButtons, text="Perpanjang", command=lambda: self.extendLoan(entryId.get())).pack(side='left', padx=5)
        ttk.Button(frameButtons, text="Kembalikan", command=lambda: self.returnBook(entryId.get())).pack(side='left', padx=5)

    def checkBookInfo(self, bookId):
        """ Menampilkan informasi buku berdasarkan ID. """
        if bookId in self.bookData:
            bookInfo = self.bookData[bookId]
            dueDate = time.strftime("%Y-%m-%d", time.localtime(bookInfo["dueDate"]))
            messagebox.showinfo("Informasi Buku", f"Judul: {bookInfo['title']}\nJatuh Tempo: {dueDate}\nDenda: {bookInfo['fine']} IDR")
        else:
            messagebox.showerror("Error", "Buku tidak ditemukan.")

    def returnBook(self, bookId):
        """ Memproses pengembalian buku dan pembayaran denda jika ada. """
        if bookId in self.bookData:
            bookInfo = self.bookData[bookId]
            if bookInfo["fine"] > 0:
                self.paymentWindow(bookId)
            else:
                messagebox.showinfo("Sukses", f"Buku '{bookInfo['title']}' berhasil dikembalikan tanpa denda.")
                del self.bookData[bookId]
                self.saveData()
        else:
            messagebox.showerror("Error", "ID Buku tidak ditemukan.")

    def paymentWindow(self, bookId):
        """ Menampilkan opsi pembayaran denda. """
        payWindow = tk.Toplevel(self.root)
        payWindow.title("Pembayaran Denda")
        payWindow.geometry("400x250")

        bookInfo = self.bookData[bookId]

        ttk.Label(payWindow, text=f"Denda: {bookInfo['fine']} IDR", font=("Arial", 12)).pack(pady=10)

        ttk.Label(payWindow, text="Masukkan jumlah pembayaran:").pack()
        entryAmount = ttk.Entry(payWindow)
        entryAmount.pack()

        def confirmPayment():
            """ Memproses pembayaran denda. """
            try:
                amount = int(entryAmount.get())
                if amount >= bookInfo['fine']:
                    messagebox.showinfo("Pembayaran Berhasil", f"Pembayaran {amount} IDR berhasil.")
                    bookInfo["fine"] = 0  # Reset denda ke 0 setelah pembayaran
                    self.saveData()
                    payWindow.destroy()
                else:
                    messagebox.showerror("Error", "Jumlah pembayaran kurang!")
            except ValueError:
                messagebox.showerror("Error", "Masukkan angka yang valid!")

        ttk.Button(payWindow, text="Konfirmasi", command=confirmPayment).pack(pady=10)

    def extendLoan(self, bookId):
        """ Memperpanjang masa peminjaman buku jika belum jatuh tempo. """
        if bookId in self.bookData:
            bookInfo = self.bookData[bookId]
            today = time.time()
            dueDate = bookInfo["dueDate"]

            if today > dueDate:
                if bookInfo["fine"] > 0:
                    messagebox.showwarning("Denda Belum Dibayar", "Anda harus membayar denda terlebih dahulu sebelum memperpanjang peminjaman.")
                    self.paymentWindow(bookId)  # Arahkan ke pembayaran denda
                else:
                    messagebox.showerror("Error", "Buku sudah melewati tenggat waktu.")
            else:
                newDueDate = dueDate + (self.maxExtensionDays * 86400)  # Tambahkan 7 hari
                bookInfo["dueDate"] = newDueDate
                self.saveData()
                messagebox.showinfo("Sukses", f"Peminjaman buku '{bookInfo['title']}' diperpanjang hingga {time.strftime('%Y-%m-%d', time.localtime(newDueDate))}.")
        else:
            messagebox.showerror("Error", "ID Buku tidak ditemukan.")


if __name__ == "__main__":
    root = tk.Tk()
    app = ReturnAndFineSystem(root)
    root.mainloop()
