<template>
  <CRow>
    <CCol :xs="12">
      <CCard class="mb-4">
        <CCardHeader> 
          <strong>Tambah</strong> <small>Pegawai</small>
        </CCardHeader>
        <CCardBody>
          <CForm>
              <div class="mb-3">
                <CFormLabel for="firstname"
                  >Nama Depan</CFormLabel
                >
                <CFormInput
                  id="firstname"
                  type="text"
                  placeholder="Nama Depan"
                />
              </div>
              <div class="mb-3">
                <CFormLabel for="lastname"
                  >Nama Belakang</CFormLabel
                >
                <CFormInput
                  id="lastname"
                  type="text"
                  placeholder="Nama Belakang"
                />
              </div>
              <div class="mb-3">
                <CFormLabel for="email"
                  >Email address</CFormLabel
                >
                <CFormInput
                  id="email"
                  type="email"
                  placeholder="name@example.com"
                />
              </div>

              <div class="mb-3">
                <CFormLabel for="username"
                  >Login</CFormLabel
                >
                <CFormInput
                  id="username"
                  type="text"
                  placeholder="Login"
                />
              </div>

              <div class="mb-3">
                <CFormLabel for="password"
                  >Login</CFormLabel
                >
                <CFormInput
                  id="password"
                  type="password"
                  placeholder="password"
                />
              </div>
              

               <CCol :xs="12">
                <CButton color="primary" type="submit">Simpan</CButton>
              </CCol>
            </CForm>
        </CCardBody>
      </CCard>
    </CCol>
  </CRow>
</template>

<script>
export default {
  name: 'CreateEmploye',
}
</script>
